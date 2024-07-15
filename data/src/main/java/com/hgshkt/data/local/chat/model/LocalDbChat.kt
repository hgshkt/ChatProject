package com.hgshkt.data.local.chat.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat")
data class LocalDbChat(
    @PrimaryKey val id: String,
    val name: String,
    val avatarUrl: String?,
    val lastMessageId: String?
)
