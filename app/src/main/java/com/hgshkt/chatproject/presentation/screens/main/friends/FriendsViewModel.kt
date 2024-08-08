package com.hgshkt.chatproject.presentation.screens.main.friends

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.model.UiUserSimpleData
import com.hgshkt.chatproject.presentation.data.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FriendsViewModel @Inject constructor(
    private val useCases: FriendsScreenUseCases
) : ViewModel() {

    private val _friendsFlow = MutableStateFlow<List<UiUserSimpleData>>(emptyList())
    val friendsFlow: StateFlow<List<UiUserSimpleData>> get() = _friendsFlow

    private val _searchFragmentState = MutableStateFlow<State>(State.Loading)
    val searchFragmentState: StateFlow<State> get() = _searchFragmentState

    fun fetchFriends() {
        viewModelScope.launch {
            val response = useCases.getFriends.execute()
            if (response.success) {
                _friendsFlow.value = response.value!!.map { it.toUi() }
            }
        }
    }

    fun fetchUsers() {
        viewModelScope.launch {
            useCases.getRecommended.execute().apply {
                _searchFragmentState.value = if (success) {
                    State.Success(value!!.map { it.toUi() })
                } else {
                    State.Error(message)
                }
            }
        }
    }

    fun filterFriends(query: String) {
        _friendsFlow.value = useCases.filterFriendsByQuery.execute(query).map { it.toUi() }
    }

    fun search(query: String) {
        viewModelScope.launch {
            useCases.searchUsersByQuery.execute(query).apply {
                _searchFragmentState.value = if (success) {
                    State.Success(value!!.map { it.toUi() })
                } else {
                    State.Error(message)
                }
            }
        }
    }

    fun sendInvite(id: String) {
        viewModelScope.launch {
            useCases.sendInvite.execute(id)
        }
    }

    fun delete(id: String) {
        viewModelScope.launch {
            _friendsFlow.value = _friendsFlow.value
                .toMutableList()
                .apply {
                    removeIf {
                        it.id == id
                    }
                }
            useCases.delete.execute(id)
        }
    }

    sealed class State {
        data object Loading : State()
        data class Success(val users: List<UiUserSimpleData>) : State()
        data class Error(val message: String) : State()
    }
}