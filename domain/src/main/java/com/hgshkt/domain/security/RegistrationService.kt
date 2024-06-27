package com.hgshkt.domain.security

interface RegistrationService {
    fun createUser(registrationData: RegistrationData)

    data class RegistrationData(
        val login: String,
        val password: String
    )
}