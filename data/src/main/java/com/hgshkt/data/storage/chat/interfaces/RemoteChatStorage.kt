package com.hgshkt.data.storage.chat.interfaces

import com.hgshkt.data.storage.chat.model.StorageChat
import com.hgshkt.domain.model.Chat

interface RemoteChatStorage {
    suspend fun getChat(chatId: String): ChatStorageResponse
    suspend fun getChats(id: String): List<Chat>

    sealed class ChatStorageResponse(
        val success: Boolean,
        open val message: String,
        open val value: StorageChat?
    ) {
        data class Success(val chat: StorageChat) : ChatStorageResponse(
            success = true,
            message = "Chat received",
            value = chat
        )

        data class Failure(
            override val message: String = "Some error occurred"
        ) : ChatStorageResponse(
            success = false,
            message = message,
            value = null
        )
    }
}