package com.hgshkt.data.mapper

import com.hgshkt.data.storage.chat.interfaces.ChatStorage
import com.hgshkt.data.storage.chat.interfaces.ChatStorage.ChatStorageResponse
import com.hgshkt.data.storage.chat.model.StorageChat
import com.hgshkt.domain.data.repository.ChatRepository.GetChatResponse
import com.hgshkt.domain.model.Chat


fun ChatStorage.ChatStorageResponse.toRepoResponse(): GetChatResponse {
    return when(this) {
        is ChatStorageResponse.Success -> GetChatResponse.Success(chat.toDomain())
        is ChatStorageResponse.Failure -> GetChatResponse.Failure(message)
    }
}

fun StorageChat.toDomain(): Chat {
    return Chat(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}

