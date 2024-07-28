package com.hgshkt.domain.data

sealed class Resultc<out T>(
    val success: Boolean,
    val message: String,
    val value: T?
) {
    data class Success<out T>(val t: T) : Resultc<T>(
        success = true,
        message = "Successfully received",
        value = t
    )

    data class Failure<out T>(val msg: String = "Some error occurred") : Resultc<T>(
        success = false,
        message = msg,
        value = null
    )
}