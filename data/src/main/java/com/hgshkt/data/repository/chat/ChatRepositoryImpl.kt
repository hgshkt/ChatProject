package com.hgshkt.data.repository.chat

import com.hgshkt.data.mapper.toRepoResponse
import com.hgshkt.data.storage.chat.interfaces.ChatStorage
import com.hgshkt.domain.data.repository.ChatRepository

class ChatRepositoryImpl(
private val storage: ChatStorage
): ChatRepository {
    override suspend fun getChat(chatId: String): ChatRepository.GetChatResponse {
        return storage.getChat(chatId).toRepoResponse()
    }
}