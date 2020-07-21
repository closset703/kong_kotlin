package co.kr.unli.server.repository

import co.kr.unli.server.domain.Accounts
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Accounts, Long>