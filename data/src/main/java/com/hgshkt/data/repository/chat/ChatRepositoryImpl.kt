package com.hgshkt.data.repository.chat

import com.hgshkt.data.mapper.toDomain
import com.hgshkt.data.mapper.toRepoResponse
import com.hgshkt.data.storage.chat.interfaces.LocalChatStorage
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.domain.data.repository.ChatRepository

class ChatRepositoryImpl(
    private val storage: RemoteChatStorage,
    private val localChatStorage: LocalChatStorage
) : ChatRepository {
    override suspend fun getChat(chatId: String): ChatRepository.GetChatResponse {
        val localChat = localChatStorage.getChatById(chatId)
        localChat?.let {
            return ChatRepository.GetChatResponse.Success(localChat.toDomain())
        }
        return storage.getChat(chatId).toRepoResponse()
    }
}