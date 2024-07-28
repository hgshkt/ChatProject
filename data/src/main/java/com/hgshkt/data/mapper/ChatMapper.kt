package com.hgshkt.data.mapper

import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage.ChatStorageResponse
import com.hgshkt.data.storage.chat.model.StorageChat
import com.hgshkt.domain.data.repository.ChatRepository.GetChatResponse
import com.hgshkt.domain.model.Chat


fun RemoteChatStorage.ChatStorageResponse.toRepoResponse(): GetChatResponse {
    return when(this) {
        is ChatStorageResponse.Success -> GetChatResponse.Success(chat.toDomain())
        is ChatStorageResponse.Failure -> GetChatResponse.Failure(message)
    }
}

fun StorageChat.toDomain(): Chat {
    return Chat(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        lastMessage = null
    )
}

fun Chat.toStorage(): StorageChat {
    return StorageChat(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        lastMessageId = lastMessage?.id
    )
}

