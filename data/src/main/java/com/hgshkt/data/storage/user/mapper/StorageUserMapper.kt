package com.hgshkt.data.storage.user.mapper

import com.hgshkt.data.local.user.model.LocalDbUser
import com.hgshkt.data.remote.api.user.model.JsonUser
import com.hgshkt.data.remote.api.user.reponse.ApiUserListResponse
import com.hgshkt.data.remote.api.user.reponse.ApiUserResponse
import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.model.StorageUser

fun ApiUserResponse.toStorage(): StorageResult<StorageUser> {
    return if (success)
        StorageResult.Success(jsonUser!!.toStorage())
    else
        StorageResult.Failure(message)
}

fun ApiUserListResponse.toStorage(): StorageResult<List<StorageUser>> {
    return if (success)
        StorageResult.Success(jsonUsers!!.map { user -> user.toStorage() })
    else
        StorageResult.Failure(message)
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