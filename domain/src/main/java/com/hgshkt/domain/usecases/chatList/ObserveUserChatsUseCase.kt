package com.hgshkt.domain.usecases.chatList

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.model.Chat
import kotlinx.coroutines.flow.Flow

class ObserveUserChatsUseCase(
    private val chatRepository: ChatRepository
) {
    suspend fun execute(): Flow<List<Chat>> {
        chatRepository.observeChatList()
        return chatRepository.chats
    }
}