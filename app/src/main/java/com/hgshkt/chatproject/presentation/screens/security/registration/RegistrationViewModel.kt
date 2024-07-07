package com.hgshkt.chatproject.presentation.screens.security.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.security.RegistrationService
import com.hgshkt.domain.usecases.secutity.RegistrationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registrationUseCase: RegistrationUseCase
): ViewModel() {
    fun register(
        name: String,
        login: String,
        password: String
    ) {
        val data = RegistrationService.RegistrationData(name, login, password)
        viewModelScope.launch {
            registrationUseCase.execute(data)
        }
    }
}