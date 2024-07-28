package com.hgshkt.domain.data

//sealed class Result<out T> {
//    data class Success<out T>(val value: T) : Result<T>()
//    data class Error(val exception: String) : Result<Nothing>()
//}

sealed class Resultc<out T>(
    val success: Boolean,
    val message: String,
    val value: T?
) {
    data class Success<out T>(val user: T) : Resultc<T>(
        success = true,
        message = "Successfully received",
        value = user
    )

    data class Failure<out T>(val msg: String = "Some error occurred") : Resultc<T>(
        success = false,
        message = msg,
        value = null
    )
}