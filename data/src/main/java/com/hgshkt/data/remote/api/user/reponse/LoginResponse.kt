package com.hgshkt.data.remote.api.user.reponse

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val userId: String
)
