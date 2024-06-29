package com.hgshkt.domain.usecases

import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.security.RegistrationService.RegistrationData

class RegistrationUseCase(
    private val registrationService: RegistrationService
) {
    suspend fun execute(registrationData: RegistrationData) {
        registrationService.createUser(registrationData)
    }
}