package com.hgshkt.data.storage.user.impl

import com.hgshkt.data.local.data.SharedPrefs
import com.hgshkt.data.local.user.UserDao
import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.mapper.toLocalDb
import com.hgshkt.data.storage.user.mapper.toStorage
import com.hgshkt.data.storage.user.model.StorageSimpleUser

class LocalUserStorageImpl(
    private val userDao: UserDao,
    private val prefs: SharedPrefs
): LocalUserStorage {
    override fun getCurrentUserId(): String {
        return prefs.getCurrentUserId()
    }

    override fun getUserById(id: String): StorageResult<StorageSimpleUser> {
        userDao.getById(id)?.let {
            return StorageResult.Success(it.toStorage())
        }
        return StorageResult.Failure()
    }

    override fun saveUser(user: StorageSimpleUser) {
        userDao.insert(user.toLocalDb())
    }
}