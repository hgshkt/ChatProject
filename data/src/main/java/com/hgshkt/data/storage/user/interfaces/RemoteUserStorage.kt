package com.hgshkt.data.storage.user.interfaces

import com.hgshkt.data.storage.user.model.StorageUser

interface RemoteUserStorage {
    suspend fun getUserById(id: String): UserResponse
    suspend fun getFriendsFor(id: String): UserListResponse
    suspend fun getRecommended(id: String): UserListResponse

    sealed class UserResponse(
        val success: Boolean,
        open val message: String,
        open val value: StorageUser?
    ) {
        data class Success(val user: StorageUser) : UserResponse(
            success = true,
            message = "User received",
            value = user
        )

        data class Failure(
            override val message: String = "Some error occurred"
        ) : UserResponse(
            success = false,
            message = message,
            value = null
        )
    }

    sealed class UserListResponse(
        val success: Boolean,
        open val message: String,
        open val value: List<StorageUser>?
    ) {
        data class Success(val userList: List<StorageUser>?) : UserListResponse(
            success = true,
            message = "User received",
            value = userList
        )

        data class Failure(override val message: String = "Some error occurred") : UserListResponse(
            success = false,
            message = message,
            value = null
        )
    }
}