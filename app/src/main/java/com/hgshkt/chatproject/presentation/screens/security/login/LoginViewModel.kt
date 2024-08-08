package com.hgshkt.chatproject.presentation.screens.security.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.security.LoginService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Default)
    val uiState: Flow<LoginUiState> = _uiState

    fun login(
        login: String,
        password: String
    ) {
        _uiState.value = LoginUiState.RequestSent

        val data = LoginService.LoginData.LoginPassword(
            login = login,
            password = password
        )
        viewModelScope.launch {
            val response = loginUseCase.execute(data)
            _uiState.value = if (response.success) {
                LoginUiState.Success
            } else {
                LoginUiState.Error(response.message)
            }
        }
    }
}