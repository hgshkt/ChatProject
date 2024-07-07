package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface MessageRepository {

    val messages: Flow<List<Message>>

    suspend fun loadChatMessages(chatId: String): Flow<List<Message>>

    /**
     * @param userId is id of current user
     */
    suspend fun sendMessage(chatId: String, text: String, userId: String)

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