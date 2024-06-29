package com.hgshkt.data.remote.api.user.model

data class UserResponse(
    val success: Boolean,
    val message: String,
    val user: User?
)
