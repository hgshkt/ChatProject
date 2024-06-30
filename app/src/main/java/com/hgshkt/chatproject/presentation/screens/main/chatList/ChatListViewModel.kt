package com.hgshkt.chatproject.presentation.screens.main.chatList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgshkt.chatproject.presentation.model.UiChat
import com.hgshkt.chatproject.presentation.toUI
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import com.hgshkt.domain.usecases.ConnectWebSocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CHatListViewModel @Inject constructor(
    private val connectWebSocketUseCase: ConnectWebSocketUseCase
): ViewModel() {

    private val _chats: MutableState<MutableList<UiChat>> = mutableStateOf(mutableListOf())
    val chats = _chats

    init {
        connectWebSocket()
    }

    fun connectWebSocket() {
        viewModelScope.launch {
            val listener = object : WebSocketListener {
                override fun handleNewChat(chat: Chat) {
                    _chats.value.add(chat.toUI())
                }

                override fun handleNewMessage(message: Message) {
                    _chats.value.find { it.id == message.chatId }
                        ?.let {
                            it.lastMessage = message.text
                        }
                }
            }
            connectWebSocketUseCase.execute(listener)
        }
    }

}