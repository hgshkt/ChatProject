package com.hgshkt.data.storage.chat.impl

import com.hgshkt.data.remote.api.chat.ChatApi
import com.hgshkt.data.storage.chat.interfaces.RemoteChatStorage
import com.hgshkt.data.storage.chat.mapper.toStorageResponse

class RemoteChatStorageImpl(
    private val api: ChatApi
): RemoteChatStorage {
    override suspend fun getChat(chatId: String): RemoteChatStorage.ChatStorageResponse {
        return api.getChatById(chatId).toStorageResponse()
    }
}