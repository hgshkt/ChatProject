package com.hgshkt.domain.data.websocket

import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import kotlinx.coroutines.flow.SharedFlow

interface WebSocketManager {

    val messagesFlow: SharedFlow<List<Message>>

    val chatsFlow: SharedFlow<List<Chat>>
    fun open()

    fun close()
}