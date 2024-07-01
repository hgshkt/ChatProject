package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.MessageRepository

class SendMessageUseCase(
    private val messageRepository: MessageRepository
) {
    suspend fun execute(chatId: String, text: String) {
        messageRepository.sendMessage(chatId, text)
    }
}