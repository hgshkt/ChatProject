package com.hgshkt.data.storage.chat.mapper

import com.hgshkt.data.local.chat.model.LocalDbChat
import com.hgshkt.data.remote.api.chat.model.ApiChatResponse
import com.hgshkt.data.remote.api.chat.model.JsonChat
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.data.storage.chat.model.StorageChat

fun ApiChatResponse.toStorageResponse(): RemoteChatStorage.ChatStorageResponse {
    return if (success) {
        RemoteChatStorage.ChatStorageResponse.Success(chat.toStorage())
    } else {
        RemoteChatStorage.ChatStorageResponse.Failure(message)
    }
}

fun JsonChat.toStorage(): StorageChat {
    return StorageChat(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        lastMessageId = lastMessageId
    )
}

fun LocalDbChat.toStorage(): StorageChat {
    return StorageChat(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        lastMessageId = lastMessageId
    )
}

fun StorageChat.toLocalDb(): LocalDbChat {
    return LocalDbChat(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        lastMessageId = lastMessageId
    )
}