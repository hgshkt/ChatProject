package com.hgshkt.domain.data

import com.hgshkt.domain.usecases.GetUserByIdResponse

interface UserRepository {
    suspend fun getUserById(id: UserId): GetUserByIdResponse
}

data class UserId(
    val value: String
)