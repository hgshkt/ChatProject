package com.hgshkt.chatproject.domain.usecases

import com.hgshkt.chatproject.domain.data.security.LoginService
import com.hgshkt.chatproject.domain.data.security.LoginService.LoginData

class LoginUseCase(
    private val loginService: LoginService
) {
    fun execute(loginData: LoginData) {
        loginService.login(loginData)
    }
}