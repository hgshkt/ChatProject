package com.hgshkt.data.remote.websocket.handle

import com.google.gson.Gson
import com.hgshkt.data.remote.websocket.connect.WebSocketConnector
import com.hgshkt.domain.data.websocket.JsonMessage
import com.hgshkt.domain.data.websocket.Type
import com.hgshkt.domain.data.websocket.WebSocketHandler
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message

class WebSocketHandlerImpl(
    private val connector: WebSocketConnector
): WebSocketHandler {

    private val url = ""


    override fun connectWebSocket(webSocketListener: WebSocketListener) {
        connector.connectWebSocket(url) { jsonMessage ->
            Gson().fromJson(jsonMessage, JsonMessage::class.java)
                .apply {
                    when(type) {
                        Type.NewData.Message -> webSocketListener.handleNewMessage(getMessage())
                        Type.NewData.Chat -> webSocketListener.handleNewChat(getChat())
                        Type.NewData -> webSocketListener.handleNewData(this)
                    }
                }
        }
    }

    override fun closeWebSocket() {
        connector.closeWebSocket()
    }

    private fun JsonMessage.getMessage(): Message {
        return Gson().fromJson(obj, Message::class.java)
    }

    private fun JsonMessage.getChat(): Chat {
        return Gson().fromJson(obj, Chat::class.java)
    }
}