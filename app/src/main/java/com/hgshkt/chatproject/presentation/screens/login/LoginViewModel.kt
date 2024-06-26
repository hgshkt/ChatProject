package com.hgshkt.chatproject.presentation.screens.login

import androidx.lifecycle.ViewModel
import com.hgshkt.chatproject.domain.data.security.LoginService
import com.hgshkt.chatproject.domain.usecases.LoginUseCase

class LoginViewModel(
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
        loginUseCase.execute(data)
    }
}