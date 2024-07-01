package com.hgshkt.data.storage.impl

import com.hgshkt.data.remote.api.user.UserApi
import com.hgshkt.data.storage.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.mapper.toStorageResponse

class RemoteUserStorageImpl(
    private val api: UserApi
): RemoteUserStorage {
    override suspend fun getUserById(id: String): RemoteUserStorage.RemoteUserStorageResponse {
        return api.getUserById(id.toInt()).toStorageResponse()
    }
}