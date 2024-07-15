package com.hgshkt.data.mapper

import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage.RemoteUserStorageResponse
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage.RemoteUserStorageResponse.Failure
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage.RemoteUserStorageResponse.Success
import com.hgshkt.data.storage.user.model.StorageUser
import com.hgshkt.domain.data.repository.UserRepository.GetUserByIdResponse
import com.hgshkt.domain.model.User

fun RemoteUserStorageResponse.toRepositoryResponse(): GetUserByIdResponse {
    return when(this) {
        is Success -> GetUserByIdResponse.Success(user.toDomain())
        is Failure -> GetUserByIdResponse.Failure(message)
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