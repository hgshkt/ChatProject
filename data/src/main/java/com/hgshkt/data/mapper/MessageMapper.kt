package com.hgshkt.data.mapper

import com.hgshkt.data.storage.message.interfaces.RemoteMessageStorage
import com.hgshkt.data.storage.message.interfaces.RemoteMessageStorage.MessageStorageResponse.*
import com.hgshkt.data.storage.message.model.StorageMessage
import com.hgshkt.domain.data.repository.MessageRepository.*
import com.hgshkt.domain.model.Message

fun RemoteMessageStorage.MessageStorageResponse.toRepoResponse(): ChatMessagesResponse {
    return when (this) {
        is Success -> ChatMessagesResponse.Success(
            messages.map { it.toDomain() }
        )

        is Failure -> ChatMessagesResponse.Failure(responseMessage)
    }
}

fun StorageMessage.toDomain(): Message {
    return Message(
        id = id,
        authorId = authorId,
        chatId = chatId,
        authorName = authorName,
        avatarUrl = avatarUrl ?: "avatar url is null",
        text = text
    )
}