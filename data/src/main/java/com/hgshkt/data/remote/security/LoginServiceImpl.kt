package com.hgshkt.data.remote.security

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.remote.api.user.reponse.LoginResponse
import com.hgshkt.data.remote.api.user.request.LoginRequest
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.security.LoginService.LoginData.LoginPassword

class LoginServiceImpl(
    private val api: UserApi
): LoginService {
    override suspend fun login(loginData: LoginService.LoginData): LoginService.LoginResponse {
        val request = when(loginData) {
            is LoginPassword -> loginData.toLoginRequest()
        }
        return api.login(request).toDomain()
    }

    private fun LoginPassword.toLoginRequest(): LoginRequest {
        return LoginRequest(
            login = login,
            password = password
        )
    }

    private fun LoginResponse.toDomain(): LoginService.LoginResponse {
        return LoginService.LoginResponse(success, message, userId)
    }
}