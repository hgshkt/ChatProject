package com.hgshkt.data.storage.user.interfaces

import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.model.StorageSimpleUser

interface LocalUserStorage {
    fun getCurrentUserId(): String
    fun getUserById(id: String): StorageResult<StorageSimpleUser>
    fun saveUser(user: StorageSimpleUser)
}