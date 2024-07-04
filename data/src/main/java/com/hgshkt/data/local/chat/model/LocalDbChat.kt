package com.hgshkt.data.local.chat.model

import androidx.room.Entity

@Entity(tableName = "chat")
data class LocalDbChat(
    val id: String,
    val name: String,
    val avatarUrl: String?
)
