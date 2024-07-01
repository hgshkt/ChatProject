package com.hgshkt.chatproject.presentation.screens.main.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.toUI
import com.hgshkt.chatproject.presentation.model.UiChat
import com.hgshkt.chatproject.presentation.model.UiMessage
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.data.websocket.WebSocketManager
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val webSocketManager: WebSocketManager
): ViewModel() {

    private val _messages = MutableLiveData<MutableList<UiMessage>>(mutableListOf())
    val messages = _messages

    init {
        connectWebSocket()
    }

    fun connectWebSocket() {
        viewModelScope.launch {
            val listener = object : WebSocketListener {
                override fun handleNewChat(chat: Chat) {}

                override fun handleNewMessage(message: Message) {
                    _messages.value!!.add(message.toUI())
                }
            }
            webSocketManager.open(listener)
        }
    }
}