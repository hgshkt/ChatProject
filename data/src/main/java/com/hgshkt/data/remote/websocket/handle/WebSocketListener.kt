package com.hgshkt.data.remote.websocket.handle

interface WebSocketListener {
    fun handleNewData(message: Message)
}