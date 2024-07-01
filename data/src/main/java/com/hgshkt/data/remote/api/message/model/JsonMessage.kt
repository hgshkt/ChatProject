package com.hgshkt.data.remote.api.message.model

data class JsonMessage(
    val id: String,
    val authorId: String,
    val chatId: String,
    val authorName: String,
    val avatarUrl: String?,
    val text: String
)
