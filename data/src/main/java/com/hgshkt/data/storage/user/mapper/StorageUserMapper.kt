package com.hgshkt.data.storage.user.mapper

import com.hgshkt.data.local.user.model.LocalDbUser
import com.hgshkt.data.remote.api.user.model.JsonSimpleUser
import com.hgshkt.data.remote.api.user.model.JsonUser
import com.hgshkt.data.remote.api.user.reponse.ApiUserListResponse
import com.hgshkt.data.remote.api.user.reponse.ApiUserResponse
import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.model.StorageSimpleUser

fun ApiUserResponse.toStorage(): StorageResult<StorageSimpleUser> {
    return if (success)
        StorageResult.Success(jsonUser!!.toStorage())
    else
        StorageResult.Failure(message)
}

fun ApiUserListResponse.toStorage(): StorageResult<List<StorageSimpleUser>> {
    return if (success)
        StorageResult.Success(jsonUsers!!.map { user -> user.toStorage() })
    else
        StorageResult.Failure(message)
}

fun JsonSimpleUser.toStorage(): StorageSimpleUser {
    return StorageSimpleUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}

fun JsonUser.toStorage(): StorageSimpleUser {
    return StorageSimpleUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}

fun LocalDbUser.toStorage(): StorageSimpleUser {
    return StorageSimpleUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}

fun StorageSimpleUser.toLocalDb(): LocalDbUser {
    return LocalDbUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}