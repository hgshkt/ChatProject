package com.hgshkt.data.storage.user.impl

import com.hgshkt.data.local.user.UserDao
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.mapper.toLocalDb
import com.hgshkt.data.storage.user.mapper.toStorage
import com.hgshkt.data.storage.user.model.StorageUser

class LocalUserStorageImpl(
    private val userDao: UserDao
): LocalUserStorage {
    override fun getCurrentUserId(): String {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: String): StorageUser? {
        return userDao.getById(id)?.toStorage()
    }

    override fun saveUser(user: StorageUser) {
        userDao.insert(user.toLocalDb())
    }
}