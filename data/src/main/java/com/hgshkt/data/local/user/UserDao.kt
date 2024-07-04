package com.hgshkt.data.local.user

import androidx.room.Dao
import androidx.room.Query
import com.hgshkt.data.local.user.model.LocalDbUser

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id=:id")
    fun getById(id: String): LocalDbUser
}