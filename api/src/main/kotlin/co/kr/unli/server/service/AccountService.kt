package co.kr.unli.server.service

import co.kr.unli.server.domain.Accounts
import co.kr.unli.server.dto.JoinRequest
import co.kr.unli.server.repository.AccountRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class AccountService(
    val accountRepository: AccountRepository
) {
    fun join(joinRequest: JoinRequest) {
        accountRepository.save(
            Accounts(
                di = joinRequest.di,
                name = joinRequest.name,
                mobile = joinRequest.mobile
            )
        )
    }
}