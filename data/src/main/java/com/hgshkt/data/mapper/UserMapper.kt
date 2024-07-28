package com.hgshkt.data.mapper

import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.data.storage.user.model.StorageUser
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.User


fun RemoteUserStorage.UserResponse.toRepository(): UserRepository.UserResponse {
    return when (this) {
        is RemoteUserStorage.UserResponse.Success ->
            UserRepository.UserResponse.Success(user.toDomain())

        is RemoteUserStorage.UserResponse.Failure ->
            UserRepository.UserResponse.Failure(message)
    }
}

fun RemoteUserStorage.UserListResponse.toRepository(): UserRepository.UserListResponse {
    return when (this) {
        is RemoteUserStorage.UserListResponse.Success ->
            UserRepository.UserListResponse.Success(userList!!.map { it.toDomain() })

        is RemoteUserStorage.UserListResponse.Failure ->
            UserRepository.UserListResponse.Failure(message)
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