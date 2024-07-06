package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.Chat
import kotlinx.coroutines.flow.Flow

class GetUserChatsUseCase(
    private val chatRepository: ChatRepository,
    private val userRepository: UserRepository
) {
    fun execute(): Flow<List<Chat>> {
        val id = userRepository.getCurrentUserId()
        return chatRepository.getChatList(id)
    }
}