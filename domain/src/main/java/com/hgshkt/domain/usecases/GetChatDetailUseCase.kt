package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import com.hgshkt.domain.usecases.GetChatDetailUseCase.ChatDetailResponse.*

class GetChatDetailUseCase(
    private val chatRepository: ChatRepository,
    private val messageRepository: MessageRepository
) {
    private val msgError = "Messages fetching error"
    private val chatError = "Chat fetching error"

    suspend fun execute(chatId: String): ChatDetailResponse {
        val chatResponse = chatRepository.getChat(chatId)
        val messageResponse = messageRepository.loadChatMessages(chatId)
        return if (chatResponse.success) {
            if (messageResponse.success) {
                Success(
                    chat = chatResponse.value!!,
                    messages = messageResponse.value!!
                )
            } else Failure(msgError)
        } else Failure(chatError)
    }

    sealed class ChatDetailResponse(
        open val chat: Chat?,
        open val messages: List<Message>?,
        val success: Boolean,
        val responseMessage: String
    ) {
        data class Success(
            override val chat: Chat,
            override val messages: List<Message>
        ) : ChatDetailResponse(
            chat = chat,
            messages = messages,
            success = true,
            responseMessage = "Chat and messages fetched successful"
        )

        data class Failure(
            val message: String = "Some error occurred"
        ) : ChatDetailResponse(
            chat = null,
            messages = null,
            success = false,
            responseMessage = message
        )
    }
}