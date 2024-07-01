package com.hgshkt.data.storage.chat.mapper

import com.hgshkt.data.remote.api.chat.model.ApiChatResponse
import com.hgshkt.data.remote.api.chat.model.JsonChat
import com.hgshkt.data.storage.chat.interfaces.ChatStorage
import com.hgshkt.data.storage.chat.model.StorageChat

fun ApiChatResponse.toStorageResponse(): ChatStorage.ChatStorageResponse {
    return if (success) {
        ChatStorage.ChatStorageResponse.Success(chat.toStorage())
    } else {
        ChatStorage.ChatStorageResponse.Failure(message)
    }
}

private fun JsonChat.toStorage(): StorageChat {
    return StorageChat(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}