package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.Chat

interface ChatRepository {
    suspend fun getChat(chatId: String): GetChatResponse

    sealed class GetChatResponse(
        val success: Boolean,
        val message: String,
        val value: Chat?
    ) {
        data class Success(val chat: Chat): GetChatResponse(
            success = true,
            message = "Chat loaded successful",
            value = chat
        )

        data class Failure(val msg: String = "Some error occurred"): GetChatResponse(
            success = false,
            message = msg,
            value = null
        )
    }
}