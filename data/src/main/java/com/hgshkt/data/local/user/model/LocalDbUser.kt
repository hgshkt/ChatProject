package com.hgshkt.data.local.user.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class LocalDbUser(
    @PrimaryKey
    val id: String,
    val name: String?,
    val avatarUrl: String?,
    val backgroundUrl: String?
)
