package com.hgshkt.data.repository.chat

import com.hgshkt.data.mapper.toChatOrNull
import com.hgshkt.data.mapper.toDomain
import com.hgshkt.data.mapper.toMessageOrNull
import com.hgshkt.data.storage.chat.interfaces.LocalChatStorage
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.data.storage.data.interfaces.LocalDataStorage
import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.websocket.WebSocketService
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class ChatRepositoryImpl(
    private val remoteChatStorage: RemoteChatStorage,
    private val localChatStorage: LocalChatStorage,
    private val localDataStorage: LocalDataStorage,
    private val webSocketService: WebSocketService
) : ChatRepository {

    private val _chats = MutableStateFlow<List<Chat>>(emptyList())
    override val chats: Flow<List<Chat>>
        get() = _chats

    override suspend fun observeChatList() {
        val id = localDataStorage.getCurrentUserId()!!
        val localChats = localChatStorage.getChats(id).map { it.toDomain() }
        _chats.value = localChats

        val remoteChats = remoteChatStorage.getChats(id).map { it.toDomain() }
        _chats.value = remoteChats

        webSocketService.messageFlow.collect { json ->
            json.toChatOrNull()?.let { chat ->
                handleChat(chat)
            }
            json.toMessageOrNull()?.let { message ->
                handleMessage(message)
            }
        }
    }

    override fun observeChat(chatId: String) = flow {
        localChatStorage.getChatById(chatId)?.toDomain()?.let { localData ->
            emit(localData)
        }

        remoteChatStorage.getChat(chatId).value?.toDomain()?.let { remoteData ->
            emit(remoteData)
        }

        webSocketService.messageFlow.collect { json ->
            json.toChatOrNull()?.let { chat ->
                emit(chat)
            }
        }
    }

    private fun handleChat(chat: Chat) {
        _chats.value += chat
    }

    private fun handleMessage(message: Message) {
        _chats.value.find { it.id == message.chatId }?.lastMessage = message
    }
}