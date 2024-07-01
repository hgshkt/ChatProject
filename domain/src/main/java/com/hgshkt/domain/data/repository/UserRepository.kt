package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.User

interface UserRepository {
    suspend fun getUserById(id: String): GetUserByIdResponse
    fun getCurrentUserId(): String

    sealed class GetUserByIdResponse(
        val success: Boolean,
        val message: String,
        val value: User?
    ) {
        data class Success(val user: User) : GetUserByIdResponse(
            success = true,
            message = "User received",
            value = user
        )

        data class Failure(val msg: String = "Some error occurred") : GetUserByIdResponse(
            success = false,
            message = msg,
            value = null
        )
    }
}