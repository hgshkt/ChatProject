package com.hgshkt.chatproject.presentation.screens.main.chatList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.data.toUI
import com.hgshkt.chatproject.presentation.model.UiChat
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.data.websocket.WebSocketManager
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CHatListViewModel @Inject constructor(
    private val webSocketManager: WebSocketManager
): ViewModel() {

    private val _chats = MutableLiveData<MutableList<UiChat>>(mutableListOf())
    val chats = _chats

    init {
        connectWebSocket()
    }

    fun connectWebSocket() {
        viewModelScope.launch {
            val listener = object : WebSocketListener {
                override fun handleNewChat(chat: Chat) {
                    _chats.value!!.add(chat.toUI())
                }

                override fun handleNewMessage(message: Message) {
                    _chats.value!!.find { it.id == message.chatId }
                        ?.let {
                            it.lastMessage = message.text
                        }
                }
            }
            webSocketManager.open(listener)
        }
    }

}