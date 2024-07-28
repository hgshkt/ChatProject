package com.hgshkt.chatproject.presentation.data.model

data class UiChat(
    val id: String,
    var name: String,
    var avatarUrl: String? = null,
    var lastMessage: String?
)
