package com.hgshkt.data.storage.user.impl

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.mapper.toStorage
import com.hgshkt.data.storage.user.model.StorageUser
import com.hgshkt.data.storage.user.response.FriendInviteResponse

class RemoteUserStorageImpl(
    private val api: UserApi
): RemoteUserStorage {
    override suspend fun getUserById(id: String): StorageResult<StorageUser> {
        return api.getUserById(id.toInt()).toStorage()
    }

    override suspend fun getFriendsFor(id: String): StorageResult<List<StorageUser>> {
        return api.getFriendsFor(id).toStorage()
    }

    override suspend fun getRecommended(id: String): StorageResult<List<StorageUser>> {
        return api.getRecommended(id).toStorage()
    }

    override suspend fun getUsersByQuery(query: String): StorageResult<List<StorageUser>> {
        return api.searchUsers(query).toStorage()
    }

    override suspend fun sendFriendRequest(
        from: String,
        to: String
    ): StorageResult<FriendInviteResponse> {
        return api.sendFriendRequest(from, to).toStorage()
    }
}