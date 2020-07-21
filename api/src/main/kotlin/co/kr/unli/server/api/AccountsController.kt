package co.kr.unli.server.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountsController() {
    @PostMapping("/api/command-execute/join")
    fun join() {

    }
}