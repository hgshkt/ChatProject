package com.hgshkt.data.storage.user.mapper

import com.hgshkt.data.local.chat.model.LocalDbChat
import com.hgshkt.data.local.user.model.LocalDbUser
import com.hgshkt.data.remote.api.user.model.JsonUser
import com.hgshkt.data.remote.api.user.reponse.ApiUserResponse
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.model.StorageUser
import com.hgshkt.domain.model.User

fun ApiUserResponse.toStorageResponse(): RemoteUserStorage.RemoteUserStorageResponse {
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

fun LocalDbUser.toStorage(): StorageUser {
    return StorageUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}

fun StorageUser.toLocalDb(): LocalDbUser {
    return LocalDbUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}