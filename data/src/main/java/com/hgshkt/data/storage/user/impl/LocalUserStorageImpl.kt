package com.hgshkt.data.storage.user.impl

import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.model.StorageUser

class LocalUserStorageImpl(

): LocalUserStorage {
    override fun getCurrentUserId(): String {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: String): StorageUser? {
        TODO("Not yet implemented")
    }
}