package com.hgshkt.data.storage.chat.interfaces

import com.hgshkt.data.storage.chat.model.StorageChat
import com.hgshkt.domain.model.Chat

interface LocalChatStorage {
    fun getChatById(id: String): StorageChat?
    fun save(chat: StorageChat)
    fun getChats(id: String): List<StorageChat>
}