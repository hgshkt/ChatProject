package com.hgshkt.data.storage.user.mapper

import com.hgshkt.data.local.user.model.LocalDbUser
import com.hgshkt.data.remote.api.user.model.JsonUser
import com.hgshkt.data.remote.api.user.reponse.ApiUserListResponse
import com.hgshkt.data.remote.api.user.reponse.ApiUserResponse
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.model.StorageUser

fun ApiUserResponse.toStorage(): RemoteUserStorage.UserResponse {
    return if (success) {
        RemoteUserStorage.UserResponse.Success(jsonUser!!.toStorage())
    } else
        RemoteUserStorage.UserResponse.Failure(message)
}

fun ApiUserListResponse.toStorage(): RemoteUserStorage.UserListResponse {
    return if (success) {
        RemoteUserStorage.UserListResponse.Success(jsonUsers!!.map { it.toStorage() })
    } else {
        RemoteUserStorage.UserListResponse.Failure(message)
    }
}

fun JsonUser.toStorage(): StorageUser {
    return StorageUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        backgroundUrl = backgroundUrl
    )
}

fun LocalDbUser.toStorage(): StorageUser {
    return StorageUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        backgroundUrl = backgroundUrl
    )
}

fun StorageUser.toLocalDb(): LocalDbUser {
    return LocalDbUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        backgroundUrl = backgroundUrl
    )
}