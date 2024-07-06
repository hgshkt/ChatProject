package com.hgshkt.chatproject.presentation.data

import com.hgshkt.domain.data.websocket.WebSocketHandler
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.data.websocket.WebSocketManager
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import okhttp3.WebSocket


class WebSocketManagerImpl(
    private val webSocketHandler: WebSocketHandler
): WebSocketManager {

    private val _messagesFlow = MutableStateFlow<List<Message>>(emptyList())
    override val messagesFlow: SharedFlow<List<Message>> = _messagesFlow

    private val _chatsFlow = MutableStateFlow<List<Chat>>(emptyList())
    override val chatsFlow: SharedFlow<List<Chat>> = _chatsFlow

    override fun open() {
        val listener = object : WebSocketListener {
            override fun handleNewChat(chat: Chat) {
                _chatsFlow.value += chat
            }

            override fun handleNewMessage(message: Message) {
                _messagesFlow.value += message
            }
        }
        webSocketHandler.connectWebSocket(listener)
    }

    override fun close() {
        webSocketHandler.closeWebSocket()
    }
}