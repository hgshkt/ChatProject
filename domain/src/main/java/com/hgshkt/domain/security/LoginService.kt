package com.hgshkt.domain.security

interface LoginService {
    suspend fun login(loginData: LoginData)

    sealed class LoginData {
        data class LoginPassword(
            val login: String,
            val password: String
        ): LoginData()
    }
}