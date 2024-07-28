package com.hgshkt.chatproject.presentation.screens.main.friends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.model.UiUser
import com.hgshkt.chatproject.presentation.data.toUi
import com.hgshkt.domain.usecases.friends.GetRecommendedUsersUseCase
import com.hgshkt.domain.usecases.friends.GetUserFriendsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FriendsViewModel @Inject constructor(
    private val getUserFriendsUseCase: GetUserFriendsUseCase,
    private val getRecommendedUsersUseCase: GetRecommendedUsersUseCase
): ViewModel() {

    private val _friendsFlow = MutableStateFlow<List<UiUser>>(emptyList())
    val friendsFlow: StateFlow<List<UiUser>> get() = _friendsFlow

    private val _usersFlow = MutableStateFlow<List<UiUser>>(emptyList())
    val usersFlow: StateFlow<List<UiUser>> get() = _usersFlow

    fun fetchFriends() {
        viewModelScope.launch {
            val response = getUserFriendsUseCase.execute()
            if(response.success) {
                _friendsFlow.value = response.value!!.map { it.toUi() }
            }
        }
    }

    fun fetchUsers() {
        viewModelScope.launch {
            val response = getRecommendedUsersUseCase.execute()
            if(response.success) {
                _friendsFlow.value = response.value!!.map { it.toUi() }
            }
        }
    }
}