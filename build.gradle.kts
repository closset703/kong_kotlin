import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.bundling.BootWar

plugins {
    val bootVersion = "2.3.1.RELEASE"
    val kotlinPluginVersion = "1.3.72"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    war
    kotlin("jvm") version kotlinPluginVersion
    id("org.springframework.boot") version bootVersion
    kotlin("plugin.spring") version kotlinPluginVersion
    kotlin("plugin.jpa") version kotlinPluginVersion
}

allprojects {
    repositories {
        mavenCentral()
        jcenter()
    }
}

subprojects {
    group = "co.kr.unli"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "kotlin")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
        testImplementation("org.assertj:assertj-core:3.11.1")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}


project(":api") {
    apply(plugin = "war")
    apply(plugin = "kotlin-kapt")

    dependencies {
        implementation(project(":domain:accounts"))
        implementation(project(":client:security-configuration"))
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-web")

        testImplementation("org.springframework.security:spring-security-test")
    }

    val bootWar: BootWar by tasks
    bootWar.enabled = false
    val war: War by tasks
    war.enabled = true
}
project(":domain:accounts") {
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "kotlin-kapt")

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        runtimeOnly("com.h2database:h2")
    }


    val jar: Jar by tasks
    val bootJar: BootJar by tasks

    bootJar.enabled = false
    jar.enabled = true
}

project(":client:security-configuration") {
    apply(plugin = "kotlin-kapt")

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-security")
        testImplementation("org.springframework.security:spring-security-test")
    }
    val jar: Jar by tasks
    val bootJar: BootJar by tasks
    bootJar.enabled = false
    jar.enabled = true
}