package com.hgshkt.chatproject.presentation.screens.main.test_injecting

import com.hgshkt.domain.data.websocket.WebSocketListener
import okhttp3.WebSocket

class WebSocketManager(
    private val lvl2Class: Lvl2Class
) {

    private lateinit var webSocket: WebSocket

    fun openWebSocket(listener: WebSocketListener) {
        webSocket = lvl2Class.f1(listener)
    }

    fun closeWebSocket() {
        lvl2Class.close(webSocket)
    }
}