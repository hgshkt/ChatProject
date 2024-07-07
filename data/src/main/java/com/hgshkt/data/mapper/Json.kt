package com.hgshkt.data.mapper

import com.google.gson.Gson
import com.hgshkt.domain.model.Chat
import com.hgshkt.domain.model.Message

fun String.toChatOrNull(): Chat? {
    return try {
        Gson().fromJson(this, Chat::class.java)
    } catch (e: Exception) {
        null
    }
}

fun String.toMessageOrNull(): Message? {
    return try {
        Gson().fromJson(this, Message::class.java)
    } catch (e: Exception) {
        null
    }
}