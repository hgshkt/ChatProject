package com.hgshkt.data.storage.message.model

data class StorageMessage(
    val id: String,
    val authorId: String,
    val chatId: String,
    val authorName: String,
    val avatarUrl: String,
    val text: String
)
