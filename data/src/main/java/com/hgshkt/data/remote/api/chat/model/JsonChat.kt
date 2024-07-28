package com.hgshkt.data.remote.api.chat.model

data class JsonChat(
    val id: String,
    val name: String,
    val avatarUrl: String?,
    val lastMessageId: String?
)
