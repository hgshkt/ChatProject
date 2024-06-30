package com.hgshkt.chatproject.presentation.screens.main.profile

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.model.User
import com.hgshkt.domain.usecases.GetCurrentUserUseCase
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getUser: GetCurrentUserUseCase
): ViewModel() {
    private val _user: MutableState<User?> = mutableStateOf(null)
    val user = _user

    init {
        fetchUser()
    }

    fun fetchUser() {
        viewModelScope.launch {
            val response = getUser.execute()
            if (response.success) {
                _user.value = response.value
            }
        }
    }
}