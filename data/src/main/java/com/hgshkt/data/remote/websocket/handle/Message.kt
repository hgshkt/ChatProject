package com.hgshkt.data.remote.websocket.handle

data class Message(
    val type: Type
)
sealed class Type {
    data object NewData: Type()
}
