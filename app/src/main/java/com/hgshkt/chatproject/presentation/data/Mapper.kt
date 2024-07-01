package com.hgshkt.chatproject.presentation.data

import com.hgshkt.chatproject.presentation.data.model.UiChat
import com.hgshkt.chatproject.presentation.data.model.UiMessage
import com.hgshkt.chatproject.presentation.data.model.UiUser
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import com.hgshkt.domain.model.User

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

fun User.toUi(): UiUser {
    return UiUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}