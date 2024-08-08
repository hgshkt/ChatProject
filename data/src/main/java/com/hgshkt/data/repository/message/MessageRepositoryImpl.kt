package com.hgshkt.data.repository.message

import com.hgshkt.data.mapper.toDomain
import com.hgshkt.data.mapper.toMessageOrNull
import com.hgshkt.data.storage.message.interfaces.LocalMessageStorage
import com.hgshkt.data.storage.message.interfaces.RemoteMessageStorage
import com.hgshkt.domain.data.repository.MessageRepository
import com.hgshkt.domain.data.websocket.WebSocketService
import com.hgshkt.domain.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class MessageRepositoryImpl(
    private val localMessageStorage: LocalMessageStorage,
    private val remoteMessageStorage: RemoteMessageStorage,
    private val webSocketService: WebSocketService,
    private val currentUserId: String
) : MessageRepository {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    override val messages: Flow<List<Message>>
        get() = _messages

    override suspend fun loadChatMessages(chatId: String) = flow {
        val localMessages = localMessageStorage.getMessagesByChatId(chatId).map { it.toDomain() }
        emit(localMessages)

        val remoteMessages = remoteMessageStorage.getMessagesByChatId(chatId)
            .map { it.toDomain() }
        emit(remoteMessages)

        webSocketService.messageFlow.collect { json ->
            json.toMessageOrNull()?.let { message ->
                handleMessage(message)
            }
        }
    }

    private fun handleMessage(message: Message) {
        _messages.value += message
    }

    override suspend fun sendMessage(chatId: String, text: String) {
        remoteMessageStorage.sendMessage(chatId, text, currentUserId)
    }
}