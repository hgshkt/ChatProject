package com.hgshkt.data.storage.user.impl

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.mapper.toStorageResponse

class RemoteUserStorageImpl(
    private val api: UserApi
): RemoteUserStorage {
    override suspend fun getUserById(id: String): RemoteUserStorage.RemoteUserStorageResponse {
        return api.getUserById(id.toInt()).toStorageResponse()
    }
}