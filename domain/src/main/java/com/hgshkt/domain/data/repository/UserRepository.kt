package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.User

interface UserRepository {
    suspend fun getUserById(id: String): UserResponse
    fun getCurrentUserId(): String
    suspend fun getFriendsFor(id: String): UserListResponse
    suspend fun getRecommended(id: String): UserListResponse

    sealed class UserResponse(
        val success: Boolean,
        val message: String,
        val value: User?
    ) {
        data class Success(val user: User) : UserResponse(
            success = true,
            message = "User received",
            value = user
        )

        data class Failure(val msg: String = "Some error occurred") : UserResponse(
            success = false,
            message = msg,
            value = null
        )
    }

    sealed class UserListResponse(
        val success: Boolean,
        val message: String,
        val value: List<User>?
    ) {
        data class Success(val user: List<User>) : UserListResponse(
            success = true,
            message = "User list received",
            value = user
        )

        data class Failure(val msg: String = "Some error occurred") : UserListResponse(
            success = false,
            message = msg,
            value = null
        )
    }
}