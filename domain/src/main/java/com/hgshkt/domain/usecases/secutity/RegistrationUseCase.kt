package com.hgshkt.domain.usecases.secutity

import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.security.RegistrationService.RegistrationData

class RegistrationUseCase(
    private val registrationService: RegistrationService
) {
    suspend fun execute(
        registrationData: RegistrationData
    ): RegistrationService.RegistrationResponse {
        return registrationService.createUser(registrationData)
    }
}