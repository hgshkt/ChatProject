package com.hgshkt.data.remote.websocket.handle

import com.google.gson.Gson
import com.hgshkt.data.remote.websocket.connect.WebSocketConnector
import com.hgshkt.domain.data.websocket.Message
import com.hgshkt.domain.data.websocket.Type
import com.hgshkt.domain.data.websocket.WebSocketHandler
import com.hgshkt.domain.data.websocket.WebSocketListener

class WebSocketHandlerImpl(
    private val connector: WebSocketConnector
): WebSocketHandler {
    private val url = ""
    override fun connectWebSocket(webSocketListener: WebSocketListener) {
        connector.connectWebSocket(url) {
            val message = Gson().fromJson(it, Message::class.java)
            when(message.type) {
                is Type.NewData -> webSocketListener.handleNewData(message)
            }
        }
    }
}