package com.hgshkt.data.storage.chat.impl

import com.hgshkt.data.local.chat.ChatDao
import com.hgshkt.data.storage.chat.interfaces.LocalChatStorage
import com.hgshkt.data.storage.chat.mapper.toStorage
import com.hgshkt.data.storage.chat.model.StorageChat

class LocalChatStorageImpl(
    private val chatDao: ChatDao
): LocalChatStorage {
    override fun getChatById(id: String): StorageChat? {
        return chatDao.getById(id)?.toStorage()
    }
}