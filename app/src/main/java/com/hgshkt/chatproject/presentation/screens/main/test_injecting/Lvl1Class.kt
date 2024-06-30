package com.hgshkt.chatproject.presentation.screens.main.test_injecting

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class Lvl1Class(
    private val client: OkHttpClient
) {
    val url = ""

    fun f1(
        onMessage: (String) -> Unit
    ): WebSocket {
        val request = Request.Builder()
            .url(url)
            .build()

        val webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)

                onMessage(text)
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                webSocket.close(1000, null)
            }
        })

        client.dispatcher.executorService.shutdown()

        return webSocket
    }

    fun close(webSocket: WebSocket) {
        webSocket.close(1000, null)
    }
}