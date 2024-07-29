package com.hgshkt.data.storage.user.interfaces

import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.model.StorageUser

interface LocalUserStorage {
    fun getCurrentUserId(): String
    fun getUserById(id: String): StorageResult<StorageUser>
    fun saveUser(user: StorageUser)
}