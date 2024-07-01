package com.hgshkt.chatproject.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.model.UiChat
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.data.websocket.WebSocketManager
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import com.hgshkt.domain.usecases.ConnectWebSocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val connectWebSocketUseCase: ConnectWebSocketUseCase,
    private val webSocketManager: WebSocketManager
): ViewModel() {

    val chats: MutableList<UiChat> = mutableListOf()

    init {
        connectWebSocket()
    }

    fun connectWebSocket() {
        viewModelScope.launch {
            val listener = MainWebSocketListener()
            connectWebSocketUseCase.execute(listener)
        }
    }

    private class MainWebSocketListener: WebSocketListener {
        override fun handleNewChat(chat: Chat) {
            TODO("Not yet implemented")
        }

        override fun handleNewMessage(message: Message) {
            TODO("Not yet implemented")
        }
    }
}