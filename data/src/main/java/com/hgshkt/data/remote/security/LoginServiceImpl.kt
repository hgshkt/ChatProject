package com.hgshkt.data.remote.security

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.remote.api.user.request.LoginRequest
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.LoginService.LoginData.*

class LoginServiceImpl(
    private val api: UserApi
): LoginService {
    override suspend fun login(loginData: LoginService.LoginData) {
        val request = when(loginData) {
            is LoginPassword -> loginData.toLoginRequest()
        }
        api.login(request)
    }

    private fun LoginPassword.toLoginRequest(): LoginRequest {
        return LoginRequest(
            login = login,
            password = password
        )
    }
}