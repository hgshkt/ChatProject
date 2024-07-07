package com.hgshkt.data.local.message.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message")
data class LocalDbMessage(
    @PrimaryKey val id: String,
    val authorId: String,
    val chatId: String,
    val authorName: String,
    val avatarUrl: String?,
    val text: String
)