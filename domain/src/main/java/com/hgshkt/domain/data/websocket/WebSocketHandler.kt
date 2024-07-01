package com.hgshkt.domain.data.websocket

import okhttp3.WebSocket

interface WebSocketHandler {
    fun connectWebSocket(webSocketListener: WebSocketListener)

    fun closeWebSocket()
}