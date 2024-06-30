package com.hgshkt.chatproject.presentation.screens.main.test_injecting

import com.google.gson.Gson
import com.hgshkt.domain.data.websocket.JsonMessage
import com.hgshkt.domain.data.websocket.Type
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import okhttp3.WebSocket

class Lvl2Class(
    private val lvl1Class: Lvl1Class
) {
    fun f1(
        listener: WebSocketListener
    ): WebSocket {
        val webSocket = lvl1Class.f1 { text ->
            Gson().fromJson(text, JsonMessage::class.java)
                .apply {
                    when (type) {
                        Type.NewData.Message -> {
                            val message = Gson().fromJson(obj, Message::class.java)
                            listener.handleNewMessage(message)
                        }

                        Type.NewData.Chat -> {
                            val chat = Gson().fromJson(obj, Chat::class.java)
                            listener.handleNewChat(chat)
                        }

                        Type.NewData -> {
                            val jsonMessage = Gson().fromJson(obj, JsonMessage::class.java)
                            listener.handleNewData(jsonMessage)
                        }
                    }
                }
        }

        return webSocket
    }

    fun close(webSocket: WebSocket) {
        lvl1Class.close(webSocket)
    }
}