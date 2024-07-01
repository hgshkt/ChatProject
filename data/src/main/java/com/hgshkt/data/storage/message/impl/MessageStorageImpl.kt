package com.hgshkt.data.storage.message.impl

import com.hgshkt.data.remote.api.message.MessageApi
import com.hgshkt.data.storage.message.interfaces.MessageStorage
import com.hgshkt.data.storage.message.mapper.toStorageResponse

class MessageStorageImpl(
    private val api: MessageApi
): MessageStorage {
    override suspend fun getMessagesByChatId(chatId: String): MessageStorage.MessageStorageResponse {
        return api.getMessagesByChatId(chatId).toStorageResponse()
    }

    override fun sendMessage(chatId: String, text: String, userId: String) {
        api.sendMessage(chatId, text, userId)
    }
}