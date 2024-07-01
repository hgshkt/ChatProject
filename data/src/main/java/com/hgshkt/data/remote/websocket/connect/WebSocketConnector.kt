package com.hgshkt.data.remote.websocket.connect

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketConnector(
    private val client: OkHttpClient
) {
    private lateinit var webSocket: WebSocket

    fun connectWebSocket(
        url: String,
        handle: (String) -> Unit
    ): WebSocket {
        val request = Request.Builder()
                .url(url)
                .build()

        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onMessage(webSocket: WebSocket, text: String) {
                super.onMessage(webSocket, text)

                handle(text)
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                webSocket.close(1000, null)
            }
        })
        client.dispatcher.executorService.shutdown()

        return webSocket
    }

    fun closeWebSocket(){
        webSocket.close(1000, null)
    }
}