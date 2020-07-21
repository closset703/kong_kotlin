package co.kr.unli.server.service

import co.kr.unli.server.configurations.IntegrationTestConfiguration
import co.kr.unli.server.dto.JoinRequest
import co.kr.unli.server.repository.AccountRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import java.util.*

@SpringBootTest(classes = [AccountService::class])
@Import(IntegrationTestConfiguration::class)
class AccountServiceTest {
    @Autowired
    lateinit var accountService: AccountService

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Test
    fun successJoin() {
        //Arrange
        val sut = UUID.randomUUID().toString()
        val expected = JoinRequest(
            sut,
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString()
        )

        //Act
        accountService.join(expected)

        //Assert
        val actual = accountRepository.findAll().last()
        Assertions.assertThat(expected).isEqualToIgnoringGivenFields(
            actual, "id"
        )
    }
}