package com.hgshkt.domain.model

data class Message(
    val id: String,
    val authorId: String,
    val chatId: String,
    val authorName: String,
    val avatarUrl: String,
    val text: String
)
