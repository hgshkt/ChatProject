package com.hgshkt.domain.security

interface RegistrationService {
    suspend fun createUser(registrationData: RegistrationData)

    data class RegistrationData(
        val name: String,
        val login: String,
        val password: String
    )
}