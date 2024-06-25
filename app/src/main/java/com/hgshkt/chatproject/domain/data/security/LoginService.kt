package com.hgshkt.chatproject.domain.data.security

interface LoginService {
    fun login(loginData: LoginData)

    sealed class LoginData {
        data class LoginPassword(
            val login: String,
            val password: String
        ): LoginData()
    }
}