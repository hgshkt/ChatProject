package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.websocket.WebSocketHandler
import com.hgshkt.domain.data.websocket.WebSocketListener

class ConnectWebSocketUseCase(
    private val handler: WebSocketHandler
) {
    fun execute(listener: WebSocketListener) {
        handler.connectWebSocket(listener)
    }
}