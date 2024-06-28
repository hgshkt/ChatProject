package com.hgshkt.domain.data.websocket

interface WebSocketListener {
    fun handleNewData(message: Message)
}