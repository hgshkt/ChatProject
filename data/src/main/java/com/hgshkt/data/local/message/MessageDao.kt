package com.hgshkt.data.local.message

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hgshkt.data.local.message.model.LocalDbMessage

@Dao
interface MessageDao {
    @Insert
    fun insert(localDbMessage: LocalDbMessage)

    @Query("SELECT * FROM message WHERE chatId=:id")
    fun getByChatId(id: String): List<LocalDbMessage>?
}