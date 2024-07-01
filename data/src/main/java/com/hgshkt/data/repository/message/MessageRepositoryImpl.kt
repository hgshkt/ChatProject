package com.hgshkt.data.repository.message

import com.hgshkt.data.mapper.toRepoResponse
import com.hgshkt.data.storage.message.interfaces.MessageStorage
import com.hgshkt.domain.data.repository.MessageRepository

class MessageRepositoryImpl(
    private val messageStorage: MessageStorage
) : MessageRepository {
    override suspend fun loadChatMessages(chatId: String): MessageRepository.ChatMessagesResponse {
        return messageStorage.getMessagesByChatId(chatId).toRepoResponse()
    }

    override suspend fun sendMessage(chatId: String, text: String, userId: String) {
        messageStorage.sendMessage(chatId, text, userId)
    }
}