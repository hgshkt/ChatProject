package com.hgshkt.data.storage.message.impl

import com.hgshkt.data.local.message.MessageDao
import com.hgshkt.data.storage.message.interfaces.LocalMessageStorage
import com.hgshkt.data.storage.message.mapper.toLocalDb
import com.hgshkt.data.storage.message.mapper.toStorage
import com.hgshkt.data.storage.message.model.StorageMessage

class LocalMessageStorageImpl(
    private val messageDao: MessageDao
): LocalMessageStorage {
    override fun getMessagesByChatId(chatId: String): List<StorageMessage> {
        return messageDao.getByChatId(chatId)?.map { it.toStorage() } ?: emptyList()
    }

    override fun saveMessageLocally(message: StorageMessage) {
        messageDao.insert(message.toLocalDb())
    }
}