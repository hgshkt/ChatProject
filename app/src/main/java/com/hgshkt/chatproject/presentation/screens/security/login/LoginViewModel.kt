package com.hgshkt.chatproject.presentation.screens.security.login

import androidx.lifecycle.ViewModel
import com.hgshkt.domain.security.LoginService
import com.hgshkt.domain.usecases.LoginUseCase

class LoginViewModel(
    private val loginUseCase: com.hgshkt.domain.usecases.LoginUseCase
): ViewModel() {
    fun login(
        login: String,
        password: String
    ) {
        val data = com.hgshkt.domain.security.LoginService.LoginData.LoginPassword(
            login = login,
            password = password
        )
        loginUseCase.execute(data)
    }
}