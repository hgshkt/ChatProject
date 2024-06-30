package com.hgshkt.chatproject.presentation.screens.main.test_injecting

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.hgshkt.chatproject.presentation.model.UiChat
import com.hgshkt.domain.data.websocket.JsonMessage
import com.hgshkt.domain.data.websocket.Type
import com.hgshkt.domain.data.websocket.WebSocketListener
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import com.hgshkt.domain.usecases.ConnectWebSocketUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val connectWebSocketUseCase: ConnectWebSocketUseCase,
    private val lvl2Class: Lvl2Class
) : ViewModel() {

    val chats: MutableList<UiChat> = mutableListOf()

    lateinit var webSocket: WebSocket

    init {

        lvl2Class.f1(object : WebSocketListener {
            override fun handleNewChat(chat: Chat) {
                TODO("Not yet implemented")
            }

            override fun handleNewMessage(message: Message) {
                TODO("Not yet implemented")
            }

            override fun close(webSocket: WebSocket) {
                webSocket.close(1000, null)
            }
        })
    }

    fun handleMessage(message: Message) {

    }

    fun handleNewChat(chat: Chat) {

    }

    fun handleNewData(text: String) {

    }

    private fun JsonMessage.getMessage(): Message {

    }

    private fun JsonMessage.getChat(): Chat {
        return Gson().fromJson(obj, Chat::class.java)
    }

    override fun onCleared() {
        super.onCleared()
        listener.close()
    }
}