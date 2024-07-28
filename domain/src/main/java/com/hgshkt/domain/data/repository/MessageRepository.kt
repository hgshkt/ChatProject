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
}