package com.hgshkt.data.storage.chat.impl

import com.hgshkt.data.local.chat.ChatDao
import com.hgshkt.data.storage.chat.interfaces.LocalChatStorage
import com.hgshkt.data.storage.chat.mapper.toLocalDb
import com.hgshkt.data.storage.chat.mapper.toStorage
import com.hgshkt.data.storage.chat.model.StorageChat
import com.hgshkt.domain.model.Chat

class LocalChatStorageImpl(
    private val chatDao: ChatDao
): LocalChatStorage {
    override fun getChatById(id: String): StorageChat? {
        return chatDao.getById(id)?.toStorage()
    }

    override fun save(chat: StorageChat) {
        chatDao.insert(chat.toLocalDb())
    }

    override fun getChats(id: String): List<StorageChat> {
        return chatDao.getUserChats().map { it.toStorage() }
    }
}