package com.hgshkt.data.repository.chat

import com.google.gson.Gson
import com.hgshkt.data.storage.chat.interfaces.LocalChatStorage
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.data.storage.data.interfaces.LocalDataStorage
import com.hgshkt.domain.data.repository.ChatRepository
import com.hgshkt.domain.data.websocket.WebSocketService
import com.hgshkt.domain.model.Chat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
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

    override fun getChatList() = flow<List<Chat>> {
        val id = localDataStorage.getCurrentUserId()!!
        val localChats = localChatStorage.getChats(id)
        _chats.tryEmit(localChats)

        val remoteChats = remoteChatStorage.getChats(id)
        _chats.tryEmit(remoteChats)

        webSocketService.messageFlow.collect { json ->
            json.toChatOrNull()?.let { chat ->
                handleChat(chat)
            }
            json.toMessageOrNull()?.let { message ->
                handleMessage(message)
            }
        }
    }

    private fun handleChat(chat: Chat) {
        _chats.value += chat
    }

    private fun handleMessage(message: Message) {
        _chats.value.find { it.id == message.id }.lastMessage = message
    }

    private fun String.toChatOrNull(): Chat? {
        return try {
            Gson().fromJson(this, Chat::class.java)
        } catch (e: Exception) {
            null
        }
    }

    private fun String.toMessageOrNull(): Chat? {
        return try {
            Gson().fromJson(this, Chat::class.java)
        } catch (e: Exception) {
            null
        }
    }
}