package com.hgshkt.data.storage.message.mapper

import com.hgshkt.data.local.message.model.LocalDbMessage
import com.hgshkt.data.remote.api.message.model.ApiMessageResponse
import com.hgshkt.data.remote.api.message.model.JsonMessage
import com.hgshkt.data.storage.message.interfaces.RemoteMessageStorage
import com.hgshkt.data.storage.message.model.StorageMessage


fun ApiMessageResponse.toStorageResponse(): RemoteMessageStorage.MessageStorageResponse {
    return if (success) {
        RemoteMessageStorage.MessageStorageResponse.Success(messages.map { it.toStorageMessage() })
    } else {
        RemoteMessageStorage.MessageStorageResponse.Failure(responseMessage)
    }
}

fun JsonMessage.toStorageMessage(): StorageMessage {
    return StorageMessage(
        id = id,
        authorId = authorId,
        chatId = chatId,
        authorName = authorName,
        avatarUrl = avatarUrl,
        text = text
    )
}

fun StorageMessage.toLocalDb(): LocalDbMessage {
    return LocalDbMessage(
        id = id,
        authorId = authorId,
        chatId = chatId,
        authorName = authorName,
        avatarUrl = avatarUrl,
        text = text
    )
}

fun LocalDbMessage.toStorage(): StorageMessage {
    return StorageMessage(
        id = id,
        authorId = authorId,
        chatId = chatId,
        authorName = authorName,
        avatarUrl = avatarUrl,
        text = text
    )
}