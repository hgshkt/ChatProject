package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.Chat
import kotlinx.coroutines.flow.Flow

interface ChatRepository {

    val chats: Flow<List<Chat>>
    suspend fun observeChatList()
    fun observeChat(chatId: String): Flow<Chat>
}