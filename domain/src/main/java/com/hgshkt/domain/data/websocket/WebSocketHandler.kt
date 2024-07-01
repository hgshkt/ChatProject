package com.hgshkt.domain.data.websocket

interface WebSocketHandler {
    fun connectWebSocket(webSocketListener: WebSocketListener)

    fun closeWebSocket()
}