package com.hgshkt.data.storage.chat.interfaces

import com.hgshkt.data.storage.chat.model.StorageChat

interface LocalChatStorage {
    fun getChatById(id: String): StorageChat?
}