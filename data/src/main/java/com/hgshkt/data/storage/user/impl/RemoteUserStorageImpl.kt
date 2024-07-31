package com.hgshkt.data.storage.user.impl

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.mapper.toStorage
import com.hgshkt.data.storage.user.model.StorageSimpleUser

class RemoteUserStorageImpl(
    private val api: UserApi
): RemoteUserStorage {
    override suspend fun getUserById(id: String): StorageResult<StorageSimpleUser> {
        return api.getUserById(id.toInt()).toStorage()
    }

    override suspend fun getFriendsFor(id: String): StorageResult<List<StorageSimpleUser>> {
        return api.getFriendsFor(id).toStorage()
    }

    override suspend fun getRecommended(id: String): StorageResult<List<StorageSimpleUser>> {
        return api.getRecommended(id).toStorage()
    }

    override suspend fun getUsersByQuery(query: String): StorageResult<List<StorageSimpleUser>> {
        return api.searchUsers(query).toStorage()
    }

    override suspend fun sendFriendRequest(
        from: String,
        to: String
    ) {
        api.sendFriendRequest(from, to)
    }
}