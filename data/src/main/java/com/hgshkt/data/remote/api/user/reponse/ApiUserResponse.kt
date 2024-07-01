package com.hgshkt.data.remote.api.user.reponse

import com.hgshkt.data.remote.api.user.model.JsonUser

data class ApiUserResponse(
    val success: Boolean,
    val message: String,
    val jsonUser: JsonUser?
)
