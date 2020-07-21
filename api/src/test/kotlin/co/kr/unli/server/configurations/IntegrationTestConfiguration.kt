package co.kr.unli.server.configurations

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.EnableTransactionManagement


@ExtendWith(SpringExtension::class)
@AutoConfigureDataJpa
@TestConfiguration
@EnableJpaRepositories(basePackages = ["co.kr.unli.server.repository"])
@EntityScan(basePackages = ["co.kr.unli.server.domain"])
@EnableTransactionManagement
class IntegrationTestConfiguration
