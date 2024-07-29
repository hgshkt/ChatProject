package com.hgshkt.data.mapper

import com.hgshkt.data.storage.StorageResult
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.model.StorageUser
import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.model.User
import com.hgshkt.domain.model.UserSimpleData

fun <T> StorageResult<T>.toDomain(): Resultc<T> {
    return when(this) {
        is StorageResult.Success -> Resultc.Success(value!!)
        is StorageResult.Failure -> Resultc.Failure(message)
    }
}

fun StorageUser.toDomain(): User {
    return User(
        id = id,
        name = name ?: "name is null",
        avatarUrl = avatarUrl ?: "avatar url is null",
        backgroundUrl = backgroundUrl
    )
}

fun StorageUser.toDomainSimple(): UserSimpleData {
    return UserSimpleData(
        id = id,
        name = name!!,
        avatarUrl = avatarUrl
    )
}

fun User.toStorage(): StorageUser {
    return StorageUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        backgroundUrl = backgroundUrl
    )
}