package com.hgshkt.data.storage.message.interfaces

import com.hgshkt.domain.model.Message

interface LocalMessageStorage {
    fun getMessagesByChatId(chatId: String): List<Message>
}