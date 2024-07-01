package com.hgshkt.data.storage.chat.impl

import com.hgshkt.data.remote.api.chat.ChatApi
import com.hgshkt.data.storage.chat.interfaces.ChatStorage
import com.hgshkt.data.storage.chat.mapper.toStorageResponse

class ChatStorageImpl(
    private val api: ChatApi
): ChatStorage {
    override suspend fun getChat(chatId: String): ChatStorage.ChatStorageResponse {
        return api.getChatById(chatId).toStorageResponse()
    }
}