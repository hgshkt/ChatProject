package com.hgshkt.chatproject.presentation.screens.main.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.model.UiUser
import com.hgshkt.chatproject.presentation.data.toUi
import com.hgshkt.domain.usecases.profile.GetUserByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
   private val getUserByIdUseCase: GetUserByIdUseCase
): ViewModel() {

    private val _user = MutableLiveData<UiUser>(null)
    val user = _user

    fun fetchUser(id: String) {
        viewModelScope.launch {
            val response = getUserByIdUseCase.execute(id)
            if (response.success) {
                _user.value = response.value!!.toUi()
            }
        }
    }
}