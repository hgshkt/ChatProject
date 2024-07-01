package com.hgshkt.domain.data.websocket

interface WebSocketManager {
    fun open(listener: WebSocketListener)

    fun close()
}