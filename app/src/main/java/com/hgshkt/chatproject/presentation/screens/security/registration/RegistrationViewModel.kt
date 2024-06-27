package com.hgshkt.chatproject.presentation.screens.security.registration

import androidx.lifecycle.ViewModel
import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.usecases.RegistrationUseCase

class RegistrationViewModel(
    private val registrationUseCase: RegistrationUseCase
): ViewModel() {
    fun register(
        login: String,
        password: String
    ) {
        val data = RegistrationService.RegistrationData(login, password)
        registrationUseCase.execute(data)
    }
}