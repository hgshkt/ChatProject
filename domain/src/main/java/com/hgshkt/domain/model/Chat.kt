package com.hgshkt.domain.model

data class Chat(
    val id: String,
    val name: String,
    val avatarUrl: String?,
    var lastMessage: Message?
)