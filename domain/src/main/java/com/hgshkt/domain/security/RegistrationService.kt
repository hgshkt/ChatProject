package com.hgshkt.domain.security

interface RegistrationService {
    suspend fun createUser(registrationData: RegistrationData): RegistrationResponse

    data class RegistrationResponse(
        val success: Boolean,
        val message: String,
        val createdUserId: String
    )

    data class RegistrationData(
        val name: String,
        val login: String,
        val password: String
    )
}