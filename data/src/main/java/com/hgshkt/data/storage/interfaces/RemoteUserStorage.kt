package com.hgshkt.data.storage.interfaces

import com.hgshkt.data.storage.model.StorageUser

interface RemoteUserStorage {
    suspend fun getUserById(id: String): RemoteUserStorageResponse

    sealed class RemoteUserStorageResponse(
        val success: Boolean,
        open val message: String,
        open val value: StorageUser?
    ) {
        data class Success(val user: StorageUser) : RemoteUserStorageResponse(
            success = true,
            message = "User received",
            value = user
        )

        data class Failure(
            override val message: String = "Some error occurred"
        ) : RemoteUserStorageResponse(
            success = false,
            message = message,
            value = null
        )
    }
}