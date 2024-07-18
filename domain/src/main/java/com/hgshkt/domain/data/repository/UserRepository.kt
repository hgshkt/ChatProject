package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.User
import com.hgshkt.domain.model.UserSimpleData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUserById(id: String): GetUserByIdResponse
    fun getCurrentUserId(): String
    fun getCurrentUserFriends(): Flow<UserSimpleData>
    fun getUsersByQuery(query: String): Flow<UserSimpleData>

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