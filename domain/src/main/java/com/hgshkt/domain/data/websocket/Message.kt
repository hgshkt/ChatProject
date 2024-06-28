package com.hgshkt.domain.data.websocket

data class Message(
    val type: Type
)
sealed class Type {
    data object NewData: Type()
}
