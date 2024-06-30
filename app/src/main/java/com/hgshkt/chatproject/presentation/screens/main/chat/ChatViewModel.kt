package com.hgshkt.chatproject.presentation.screens.main.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.domain.usecases.ConnectWebSocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.WebSocketListener
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val connectWebSocketUseCase: ConnectWebSocketUseCase
): ViewModel() {

    init {
        connectWebSocket()
    }

    fun connectWebSocket() {
        viewModelScope.launch {
            connectWebSocketUseCase.execute()
        }
    }

    class ChatListener: WebSocketListener() {

    }
}