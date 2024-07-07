package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import kotlinx.coroutines.flow.Flow

class GetChatDetailUseCase(
    private val chatRepository: ChatRepository,
    private val messageRepository: MessageRepository
) {

    fun execute(chatId: String): ChatDetailFlows {
        return ChatDetailFlows(
            chatFlow = chatRepository.observeChat(chatId),
            messagesFlow = messageRepository.messages
        )
    }

    data class ChatDetailFlows(
        var chatFlow: Flow<Chat>,
        val messagesFlow: Flow<List<Message>>
    )
}