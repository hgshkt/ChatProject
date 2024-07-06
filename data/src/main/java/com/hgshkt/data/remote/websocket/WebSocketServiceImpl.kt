package com.hgshkt.data.remote.websocket

import com.hgshkt.domain.data.websocket.WebSocketService
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketServiceImpl(
    private val okHttpClient: OkHttpClient
): WebSocketService {
    private val url: String = ""

    private var webSocket: WebSocket? = null
    private val _messageFlow = MutableSharedFlow<String>()
    override val messageFlow: SharedFlow<String> = _messageFlow

    override fun open() {
        val request = Request.Builder().url(url).build()
        val listener = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                this@WebSocketServiceImpl.webSocket = webSocket
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                _messageFlow.tryEmit(text)
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {}

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {}
        }
        webSocket = okHttpClient.newWebSocket(request, listener)
    }

    override fun close() {
        webSocket?.close(1000, "App closed")
        webSocket = null
    }
}