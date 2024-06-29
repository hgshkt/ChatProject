package com.hgshkt.data.remote.api.user.request

data class RegistrationRequest(
    val name: String,
    val login: String,
    val password: String
)