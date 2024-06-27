package com.hgshkt.domain.usecases

import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.LoginService.LoginData

class LoginUseCase(
    private val loginService: LoginService
) {
    fun execute(loginData: LoginData) {
        loginService.login(loginData)
    }
}