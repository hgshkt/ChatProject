package com.hgshkt.data.remote.websocket.handle

import com.google.gson.Gson
import com.hgshkt.data.remote.websocket.connect.WebSocketConnector

class WebSocketHandler(
    private val connector: WebSocketConnector
) {
    private val url = ""
    fun connectWebSocket(webSocketListener: WebSocketListener) {
        connector.connectWebSocket(url) {
            val message = Gson().fromJson(it, Message::class.java)
            when(message.type) {
                is Type.NewData -> webSocketListener.handleNewData(message)
            }
        }
    }
}