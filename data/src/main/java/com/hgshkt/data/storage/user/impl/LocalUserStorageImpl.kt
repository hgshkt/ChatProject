package com.hgshkt.data.storage.user.impl

import com.hgshkt.data.local.data.SharedPrefs
import com.hgshkt.data.local.user.UserDao
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.mapper.toLocalDb
import com.hgshkt.data.storage.user.mapper.toStorage
import com.hgshkt.data.storage.user.model.StorageUser

class LocalUserStorageImpl(
    private val userDao: UserDao,
    private val prefs: SharedPrefs
): LocalUserStorage {
    override fun getCurrentUserId(): String {
        return prefs.getCurrentUserId()
    }

    override fun getUserById(id: String): StorageUser? {
        return userDao.getById(id)?.toStorage()
    }

    override fun saveUser(user: StorageUser) {
        userDao.insert(user.toLocalDb())
    }
}