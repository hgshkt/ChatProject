package com.hgshkt.data.storage.message.interfaces

import com.hgshkt.data.storage.message.model.StorageMessage
import com.hgshkt.domain.model.Message

interface RemoteMessageStorage {
    suspend fun getMessagesByChatId(chatId: String): List<StorageMessage>

    fun sendMessage(chatId: String, text: String, userId: String)

    sealed class MessageStorageResponse(
        val success: Boolean,
        open val responseMessage: String,
        open val messages: List<StorageMessage>?
    ) {
        data class Success(override val messages: List<StorageMessage>): MessageStorageResponse(
            success = true,
            messages = messages,
            responseMessage = "Messages load successful"
        )

        data class Failure(
            override val responseMessage: String = "Some error occurred"
        ): MessageStorageResponse(
            success = false,
            messages = null,
            responseMessage = responseMessage
        )
    }
}