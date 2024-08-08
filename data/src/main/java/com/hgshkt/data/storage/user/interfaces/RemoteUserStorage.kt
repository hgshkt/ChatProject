package com.hgshkt.data.storage.user.interfaces

import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.model.StorageUser

interface RemoteUserStorage {
    suspend fun getUserById(id: String): StorageResult<StorageUser>
    suspend fun getFriendsFor(id: String): StorageResult<List<StorageUser>>
    suspend fun getRecommended(id: String): StorageResult<List<StorageUser>>
    suspend fun getUsersByQuery(query: String): StorageResult<List<StorageUser>>
    suspend fun sendFriendInvite(from: String, to: String)
}