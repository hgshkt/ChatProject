package com.hgshkt.chatproject.presentation.screens.security.login

sealed class LoginUiState {
    data object Default: LoginUiState()
    data object RequestSent: LoginUiState()
    data class Error(val message: String): LoginUiState()
    data object Success: LoginUiState()
}
