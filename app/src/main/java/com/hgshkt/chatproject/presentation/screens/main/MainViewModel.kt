package com.hgshkt.chatproject.presentation.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.hgshkt.chatproject.presentation.model.UiChat
import com.hgshkt.domain.data.websocket.JsonMessage
import com.hgshkt.domain.data.websocket.Type
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import com.hgshkt.domain.usecases.ConnectWebSocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val connectWebSocketUseCase: ConnectWebSocketUseCase
) : ViewModel() {

    val chats: MutableList<UiChat> = mutableListOf()

    val url = ""

    init {
        val request = Request.Builder()
            .url(url)
            .build()

        val client = OkHttpClient()

        val webSocket = client.newWebSocket(request, object : okhttp3.WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)

                Gson().fromJson(text, JsonMessage::class.java)
                    .apply {
                        when (type) {
                            Type.NewData.Message -> {
                                val message = Gson().fromJson(obj, Message::class.java)
                                handleMessage(message)
                            }

                            Type.NewData.Chat -> {
                                val chat = Gson().fromJson(obj, Chat::class.java)
                                handleNewChat(chat)
                            }

                            Type.NewData -> {
                                val text = obj
                                handleNewData(text ?: "")
                            }
                        }
                    }
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                webSocket.close(1000, null)
            }
        })
        client.dispatcher.executorService.shutdown()
    }

    fun handleMessage(message: Message) {

    }

    fun handleNewChat(chat: Chat) {

    }

    fun handleNewData(text: String) {

    }

    private fun JsonMessage.getMessage(): Message {
        return
    }

    private fun JsonMessage.getChat(): Chat {
        return Gson().fromJson(obj, Chat::class.java)
    }
}