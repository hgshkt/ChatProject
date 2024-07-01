package com.hgshkt.chatproject.presentation.data

import com.hgshkt.domain.data.websocket.WebSocketHandler
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.data.websocket.WebSocketManager
import okhttp3.WebSocket


class WebSocketManagerImpl(
    private val webSocketHandler: WebSocketHandler
): WebSocketManager {

    override fun open(listener: WebSocketListener) {
        webSocketHandler.connectWebSocket(listener)
    }

    override fun close() {
        webSocketHandler.closeWebSocket()
    }
}