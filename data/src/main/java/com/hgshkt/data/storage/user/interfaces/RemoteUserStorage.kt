package com.hgshkt.data.storage.user.interfaces

import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.model.StorageSimpleUser

interface RemoteUserStorage {
    suspend fun getUserById(id: String): StorageResult<StorageSimpleUser>
    suspend fun getFriendsFor(id: String): StorageResult<List<StorageSimpleUser>>
    suspend fun getRecommended(id: String): StorageResult<List<StorageSimpleUser>>
    suspend fun getUsersByQuery(query: String): StorageResult<List<StorageSimpleUser>>
    suspend fun sendFriendRequest(from: String, to: String)
}