package com.hgshkt.data.remote.api.user.reponse

import com.hgshkt.data.remote.api.user.model.JsonUser

data class UserResponse(
    val success: Boolean,
    val message: String,
    val jsonUser: JsonUser?
)
