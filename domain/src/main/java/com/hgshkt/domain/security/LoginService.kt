package com.hgshkt.domain.security

interface LoginService {
    fun login(loginData: LoginData)

    sealed class LoginData {
        data class LoginPassword(
            val login: String,
            val password: String
        ): LoginData()
    }
}