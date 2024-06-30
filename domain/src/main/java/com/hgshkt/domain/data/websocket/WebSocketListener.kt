package com.hgshkt.domain.data.websocket

import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message

interface WebSocketListener {
    fun handleNewData(jsonMessage: JsonMessage) {}

    fun handleNewChat(chat: Chat)

    fun handleNewMessage(message: Message)

    fun close()
}