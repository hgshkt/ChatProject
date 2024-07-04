package com.hgshkt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hgshkt.data.local.user.UserDao
import com.hgshkt.data.local.user.model.LocalDbUser

@Database(
    version = 1,
    entities = [
        LocalDbUser::class
    ]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}