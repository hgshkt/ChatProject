package com.hgshkt.chatproject.presentation.screens.main.friends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.model.UiUserSimpleData
import com.hgshkt.chatproject.presentation.data.toUi
import com.hgshkt.domain.usecases.friends.FilterFriendsByQueryUseCase
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
    private val getRecommendedUsersUseCase: GetRecommendedUsersUseCase,
    private val filterFriendsByQueryUseCase: FilterFriendsByQueryUseCase
): ViewModel() {

    private val _friendsFlow = MutableStateFlow<List<UiUserSimpleData>>(emptyList())
    val friendsFlow: StateFlow<List<UiUserSimpleData>> get() = _friendsFlow

    private val _usersFlow = MutableStateFlow<List<UiUserSimpleData>>(emptyList())
    val usersFlow: StateFlow<List<UiUserSimpleData>> get() = _usersFlow

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

    fun filterFriends(query: String) {
        _friendsFlow.value = filterFriendsByQueryUseCase.execute(query).map { it.toUi() }
    }
}