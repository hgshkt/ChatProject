package com.hgshkt.chatproject.presentation.screens.main.friends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.model.UiUserSimpleData
import com.hgshkt.chatproject.presentation.data.toUi
import com.hgshkt.domain.usecases.friends.FilterFriendsByQueryUseCase
import com.hgshkt.domain.usecases.friends.GetRecommendedUsersUseCase
import com.hgshkt.domain.usecases.friends.GetUserFriendsUseCase
import com.hgshkt.domain.usecases.friends.SearchUsersByQueryUseCase
import com.hgshkt.domain.usecases.friends.SendFriendRequestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FriendsViewModel @Inject constructor(
    private val getUserFriendsUseCase: GetUserFriendsUseCase,
    private val getRecommendedUsersUseCase: GetRecommendedUsersUseCase,
    private val filterFriendsByQueryUseCase: FilterFriendsByQueryUseCase,
    private val searchUsersByQueryUseCase: SearchUsersByQueryUseCase,
    private val sendFriendRequestUseCase: SendFriendRequestUseCase
) : ViewModel() {

    private val _friendsFlow = MutableStateFlow<List<UiUserSimpleData>>(emptyList())
    val friendsFlow: StateFlow<List<UiUserSimpleData>> get() = _friendsFlow

    private val _searchFragmentState = MutableStateFlow<State>(State.Loading)
    val searchFragmentState: StateFlow<State> get() = _searchFragmentState

    fun fetchFriends() {
        viewModelScope.launch {
            val response = getUserFriendsUseCase.execute()
            if (response.success) {
                _friendsFlow.value = response.value!!.map { it.toUi() }
            }
        }
    }

    fun fetchUsers() {
        viewModelScope.launch {
            getRecommendedUsersUseCase.execute().apply {
                _searchFragmentState.value = if (success) {
                    State.Success(value!!.map { it.toUi() })
                } else {
                    State.Error(message)
                }
            }
        }
    }

    fun filterFriends(query: String) {
        viewModelScope.launch {
            _friendsFlow.value = filterFriendsByQueryUseCase.execute(query).map { it.toUi() }
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            searchUsersByQueryUseCase.execute(query).apply {
                _searchFragmentState.value = if (success) {
                     State.Success(value!!.map { it.toUi() })
                } else {
                    State.Error(message)
                }
            }
        }
    }

    fun sendFriendRequest(id: String) {
        viewModelScope.launch {
            sendFriendRequestUseCase.execute(id)
        }
    }

    sealed class State {
        data object Loading : State()
        data class Success(val users: List<UiUserSimpleData>) : State()
        data class Error(val message: String) : State()
    }
}