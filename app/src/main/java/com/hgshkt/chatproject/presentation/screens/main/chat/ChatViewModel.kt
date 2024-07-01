package com.hgshkt.chatproject.presentation.screens.main.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.toUI
import com.hgshkt.chatproject.presentation.data.model.UiChat
import com.hgshkt.chatproject.presentation.data.model.UiMessage
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.data.websocket.WebSocketManager
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import com.hgshkt.domain.usecases.GetChatDetailUseCase
import com.hgshkt.domain.usecases.SendMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val webSocketManager: WebSocketManager,
    private val getChatDetailUseCase: GetChatDetailUseCase,
    private val sendMessageUseCase: SendMessageUseCase
) : ViewModel() {

    private val _chat = MutableLiveData<UiChat>()
    val chat = _chat

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
                    if (message.chatId == _chat.value!!.id)
                        _messages.value!!.add(message.toUI())
                }
            }
            webSocketManager.open(listener)
        }
    }

    fun sendMessage(text: String) {
        viewModelScope.launch {
            sendMessageUseCase.execute(_chat.value!!.id, text)
        }
    }

    fun fetchChat(id: String) {
        viewModelScope.launch {
            val response = getChatDetailUseCase.execute(id)
            if (response.success) {
                _chat.value = response.chat!!.toUI()
                _messages.value = response.messages!!.map {it.toUI()}.toMutableList()
            }
        }
    }
}