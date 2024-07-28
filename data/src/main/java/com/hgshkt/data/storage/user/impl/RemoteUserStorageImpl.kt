package com.hgshkt.data.storage.user.impl

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.mapper.toStorage

class RemoteUserStorageImpl(
    private val api: UserApi
): RemoteUserStorage {
    override suspend fun getUserById(id: String): RemoteUserStorage.UserResponse {
        return api.getUserById(id.toInt()).toStorage()
    }

    override suspend fun getFriendsFor(id: String): RemoteUserStorage.UserListResponse {
        return api.getFriendsFor(id).toStorage()
    }

    override suspend fun getRecommended(id: String): RemoteUserStorage.UserListResponse {
        return api.getRecommended(id).toStorage()
    }
}