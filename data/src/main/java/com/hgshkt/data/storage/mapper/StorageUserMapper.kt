package com.hgshkt.data.storage.mapper

import com.hgshkt.data.remote.api.user.model.JsonUser
import com.hgshkt.data.remote.api.user.reponse.UserResponse
import com.hgshkt.data.storage.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.model.StorageUser

fun UserResponse.toStorageResponse(): RemoteUserStorage.RemoteUserStorageResponse {
    return if (success) {
        RemoteUserStorage.RemoteUserStorageResponse.Success(jsonUser!!.toStorage())
    } else
        RemoteUserStorage.RemoteUserStorageResponse.Failure(message)
}

fun JsonUser.toStorage(): StorageUser {
    return StorageUser(
        id=id,
        name = name,
        avatarUrl = avatarUrl
    )
}