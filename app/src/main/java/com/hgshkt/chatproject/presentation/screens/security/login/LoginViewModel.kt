package com.hgshkt.chatproject.presentation.screens.security.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {
    fun login(
        login: String,
        password: String
    ) {
        val data = LoginService.LoginData.LoginPassword(
            login = login,
            password = password
        )
        viewModelScope.launch {
            loginUseCase.execute(data)
        }
    }
}