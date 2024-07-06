package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.model.Chat
import kotlinx.coroutines.flow.Flow

class GetUserChatsUseCase(
    private val chatRepository: ChatRepository
) {
    fun execute(): Flow<List<Chat>> {
        return chatRepository.getChatList()
    }
}