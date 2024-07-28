package com.hgshkt.data.storage.message.impl

import com.hgshkt.data.remote.api.message.MessageApi
import com.hgshkt.data.storage.message.interfaces.RemoteMessageStorage
import com.hgshkt.data.storage.message.mapper.toStorageMessage
import com.hgshkt.data.storage.message.mapper.toStorageResponse
import com.hgshkt.data.storage.message.model.StorageMessage

class RemoteMessageStorageImpl(
    private val api: MessageApi
): RemoteMessageStorage {
    override suspend fun getMessagesByChatId(chatId: String): List<StorageMessage> {
        return api.getMessagesByChatId(chatId).map { it.toStorageMessage() }
    }

    override fun sendMessage(chatId: String, text: String, userId: String) {
        api.sendMessage(chatId, text, userId)
    }
}