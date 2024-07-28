package com.hgshkt.data.mapper

import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.model.StorageUser
import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.model.User

fun RemoteUserStorage.UserResponse.toDomainResult(): Resultc<User> {
    return when (this) {
        is RemoteUserStorage.UserResponse.Success -> Resultc.Success(user.toDomain())
        is RemoteUserStorage.UserResponse.Failure -> Resultc.Failure(message)
    }
}

fun RemoteUserStorage.UserListResponse.toDomainResult(): Resultc<List<User>> {
    return when (this) {
        is RemoteUserStorage.UserListResponse.Success ->
            Resultc.Success(value!!.map { it.toDomain() })

        is RemoteUserStorage.UserListResponse.Failure ->
            Resultc.Failure(message)
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

fun User.toStorage(): StorageUser {
    return StorageUser(
        id = id,
        name = name,
        avatarUrl = avatarUrl,
        backgroundUrl = backgroundUrl
    )
}