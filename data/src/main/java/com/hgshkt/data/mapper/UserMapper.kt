package com.hgshkt.data.mapper

import com.hgshkt.data.remote.api.user.model.JsonUser
import com.hgshkt.data.storage.interfaces.RemoteUserStorage.*
import com.hgshkt.data.storage.interfaces.RemoteUserStorage.RemoteUserStorageResponse.*
import com.hgshkt.domain.data.repository.UserRepository.*
import com.hgshkt.domain.model.User

fun JsonUser.toDomain(): User {
    return User(
        id = id,
        name = name,
        avatarUrl = avatarUrl
    )
}

fun RemoteUserStorageResponse.toRepositoryResponse(): GetUserByIdResponse {
    return when(this) {
        is Success -> GetUserByIdResponse.Success(user.toDomain())
        is Failure -> GetUserByIdResponse.Failure(message)
    }
}