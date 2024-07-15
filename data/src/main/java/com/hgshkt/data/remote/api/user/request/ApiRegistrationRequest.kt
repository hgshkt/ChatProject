package com.hgshkt.data.remote.api.user.request

data class ApiRegistrationRequest(
    val name: String,
    val login: String,
    val password: String
)