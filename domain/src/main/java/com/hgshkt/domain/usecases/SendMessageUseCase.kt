package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.data.repository.UserRepository

class SendMessageUseCase(
    private val messageRepository: MessageRepository,
    private val userRepository: UserRepository
) {
    suspend fun execute(chatId: String, text: String) {
        val currentUserId = userRepository.getCurrentUserId()
        messageRepository.sendMessage(chatId, text, currentUserId)
    }
}