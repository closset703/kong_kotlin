package co.kr.unli.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(basePackages = ["co.kr.unli.server.domain"])
class ServerApplication

fun main(args: Array<String>) {
    runApplication<ServerApplication>(*args)
}
