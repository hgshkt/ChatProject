package com.hgshkt.chatproject.presentation

import com.hgshkt.chatproject.presentation.model.UiChat
import com.hgshkt.chatproject.presentation.model.UiMessage
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message

fun Chat.toUI(): UiChat {
    return UiChat(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        lastMessage = "no messages"
    )
}

fun Message.toUI(): UiMessage {
    return UiMessage(
        avatarUrl = avatarUrl,
        text = text
    )
}