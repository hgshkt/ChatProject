package com.hgshkt.chatproject.presentation.screens.main.currentProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.model.UiUser
import com.hgshkt.chatproject.presentation.data.model.UiUserSimpleData
import com.hgshkt.chatproject.presentation.data.toUi
import com.hgshkt.domain.data.repository.UserRepository.LoadUserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentProfileViewModel @Inject constructor(
    private val flowCurrentUserUseCase: FlowCurrentUserUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val state: StateFlow<State> get() = _state

    init {
        fetchUser()
    }

    fun fetchUser() {
        viewModelScope.launch {
            flowCurrentUserUseCase.execute().collect { result ->
                _state.value = when (result) {
                    is LoadUserState.LocalSuccess ->
                        State.SimpleLoaded(result.simpleData.toUi())

                    is LoadUserState.RemoteSuccess ->
                        State.Loaded(result.user.toUi())

                    is LoadUserState.RemoteError ->
                        State.Error(result.message)

                    else -> {
                        State.Loading
                    }
                }
            }
        }
    }

    sealed class State {
        data object Loading : State()
        data class SimpleLoaded(val simpleData: UiUserSimpleData) : State()
        data class Loaded(val user: UiUser) : State()
        data class Error(val message: String) : State()
    }
}