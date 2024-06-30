package com.hgshkt.domain.data.websocket

data class JsonMessage(
    val type: Type,
    /**
      json presentation of object
     */
    val obj: String?
)
sealed class Type {
    data object NewData: Type() {
        data object Chat: Type()

        data object Message: Type()
    }
}
