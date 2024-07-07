package com.hgshkt.data.local.chat

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hgshkt.data.local.chat.model.LocalDbChat
import com.hgshkt.data.storage.chat.model.StorageChat
import com.hgshkt.domain.model.Chat

@Dao
interface ChatDao {
    @Query("SELECT * FROM chat WHERE id=:id")
    fun getById(id: String): LocalDbChat?

    @Insert
    fun insert(chat: LocalDbChat)

    @Query("SELECT * FROM chat")
    fun getUserChats(): List<LocalDbChat>
}