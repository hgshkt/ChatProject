package com.hgshkt.data.storage.message.mapper

import com.hgshkt.data.remote.api.message.model.ApiMessageResponse
import com.hgshkt.data.remote.api.message.model.JsonMessage
import com.hgshkt.data.storage.message.interfaces.MessageStorage
import com.hgshkt.data.storage.message.model.StorageMessage


fun ApiMessageResponse.toStorageResponse(): MessageStorage.MessageStorageResponse {
    return if (success) {
        MessageStorage.MessageStorageResponse.Success(messages.map { it.toStorageMessage() })
    } else {
        MessageStorage.MessageStorageResponse.Failure(responseMessage)
    }
}

private fun JsonMessage.toStorageMessage(): StorageMessage {
    return StorageMessage(
        id = id,
        authorId = authorId,
        chatId = chatId,
        authorName = authorName,
        avatarUrl = avatarUrl,
        text = text
    )
}