package com.hgshkt.data.storage.interfaces

import com.hgshkt.data.remote.api.user.model.JsonUser

interface RemoteUserStorage {
    fun getUserById(): RemoteUserStorageResponse

    sealed class RemoteUserStorageResponse(
        val success: Boolean,
        open val message: String,
        open val value: JsonUser?
    ) {
        data class Success(val user: JsonUser) : RemoteUserStorageResponse(
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