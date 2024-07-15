package com.hgshkt.chatproject.presentation.screens.security.registration

sealed class RegistrationUiState {
    data object Default: RegistrationUiState()
    data object RequestSent: RegistrationUiState()
    data class Error(val message: String): RegistrationUiState()
    data object Success: RegistrationUiState()
}