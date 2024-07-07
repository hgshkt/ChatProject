package com.hgshkt.data.storage.message.interfaces

import com.hgshkt.data.storage.message.model.StorageMessage

interface LocalMessageStorage {
    fun getMessagesByChatId(chatId: String): List<StorageMessage>

    fun saveMessageLocally(message: StorageMessage)
}