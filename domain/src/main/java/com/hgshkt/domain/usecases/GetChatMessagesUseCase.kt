package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.model.Message
import kotlinx.coroutines.flow.Flow

class GetChatMessagesUseCase(
    private val messageRepository: MessageRepository
) {
    fun execute(id: String): Flow<List<Message>> {
        return messageRepository.loadChatMessages(id)
    }
}