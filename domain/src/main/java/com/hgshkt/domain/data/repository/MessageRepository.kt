package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.Message

interface MessageRepository {
    suspend fun loadChatMessages(chatId: String): ChatMessagesResponse

    suspend fun sendMessage(chatId: String, text: String)

    sealed class ChatMessagesResponse(
        val success: Boolean,
        val responseMessage: String,
        val value: List<Message>?
    ) {
        data class Success(val messages: List<Message>): ChatMessagesResponse(
            success = true,
            responseMessage = "Messages loaded successful",
            value = messages
        )

        data class Failure(val msg: String = "Some error occurred"): ChatMessagesResponse(
            success = false,
            responseMessage = msg,
            value = null
        )
    }
}