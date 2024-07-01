package com.hgshkt.data.remote.api.chat.model

data class ApiChatResponse(
    val success: Boolean,
    val message: String,
    val chat: JsonChat
)