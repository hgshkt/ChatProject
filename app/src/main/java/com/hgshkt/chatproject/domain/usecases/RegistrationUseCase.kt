package com.hgshkt.chatproject.domain.usecases

import com.hgshkt.chatproject.domain.data.security.RegistrationService
import com.hgshkt.chatproject.domain.data.security.RegistrationService.RegistrationData

class RegistrationUseCase(
    private val registrationService: RegistrationService
) {
    fun execute(registrationData: RegistrationData) {
        registrationService.createUser(registrationData)
    }
}