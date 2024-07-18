package com.hgshkt.domain.data

import com.hgshkt.domain.model.User

//sealed class Result<out T> {
//    data class Success<out T>(val value: T) : Result<T>()
//    data class Error(val exception: String) : Result<Nothing>()
//}

sealed class Result<out T>(
    val success: Boolean,
    val message: String,
    val value: T?
) {
    data class Success<out T>(val user: T) : Result<T>(
        success = true,
        message = "Successfully received",
        value = user
    )

    data class Failure<out T>(val msg: String = "Some error occurred") : Result<T>(
        success = false,
        message = msg,
        value = null
    )
}