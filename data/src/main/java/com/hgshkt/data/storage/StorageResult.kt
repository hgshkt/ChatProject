package com.hgshkt.data.storage

sealed class StorageResult<out T>(
    val success: Boolean,
    val message: String,
    val value: T?
) {
    data class Success<out T>(val t: T) : StorageResult<T>(
        success = true,
        message = "Successfully received",
        value = t
    )

    data class Failure<out T>(val msg: String = "Some error occurred") : StorageResult<T>(
        success = false,
        message = msg,
        value = null
    )
}