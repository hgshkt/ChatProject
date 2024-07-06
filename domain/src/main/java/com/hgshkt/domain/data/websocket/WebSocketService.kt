package com.hgshkt.domain.data.websocket

import kotlinx.coroutines.flow.SharedFlow

interface WebSocketService {

    val messageFlow: SharedFlow<String>

    fun open()

    fun close()
}