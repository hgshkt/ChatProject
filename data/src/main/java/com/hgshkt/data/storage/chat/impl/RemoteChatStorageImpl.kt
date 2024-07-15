package com.hgshkt.data.storage.chat.impl

import com.hgshkt.data.remote.api.chat.ChatApi
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.data.storage.chat.mapper.toStorage
import com.hgshkt.data.storage.chat.mapper.toStorageResponse
import com.hgshkt.data.storage.chat.model.StorageChat

class RemoteChatStorageImpl(
    private val api: ChatApi
): RemoteChatStorage {
    override suspend fun getChat(chatId: String): RemoteChatStorage.ChatStorageResponse {
        return api.getChatById(chatId).toStorageResponse()
    }

    override suspend fun getChats(userId: String): List<StorageChat> {
        return api.getChats(userId).map { it.chat.toStorage() }
    }
}