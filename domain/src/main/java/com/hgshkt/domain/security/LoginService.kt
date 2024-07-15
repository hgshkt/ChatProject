package com.hgshkt.domain.security

interface LoginService {
    suspend fun login(loginData: LoginData): LoginResponse

    data class LoginResponse(
        val success: Boolean,
        val message: String,
        val userId: String
    )

    sealed class LoginData {
        data class LoginPassword(
            val login: String,
            val password: String
        ): LoginData()
    }
}