package com.hgshkt.chatproject.presentation.screens.security.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.security.RegistrationService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registrationUseCase: RegistrationUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow<RegistrationUiState>(RegistrationUiState.Default)
    val uiState: Flow<RegistrationUiState> = _uiState
    fun register(
        name: String,
        login: String,
        password: String
    ) {
        _uiState.value = RegistrationUiState.RequestSent
        val data = RegistrationService.RegistrationData(name, login, password)
        viewModelScope.launch {
            val response = registrationUseCase.execute(data)
            _uiState.value = if(response.success) {
                RegistrationUiState.Success
            } else {
                RegistrationUiState.Error(response.message)
            }
        }
    }
}