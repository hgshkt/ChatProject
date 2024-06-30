package com.hgshkt.domain.model

data class Message(
    val authorId: String,
    val authorName: String,
    val avatarUrl: String,
    val text: String
)
