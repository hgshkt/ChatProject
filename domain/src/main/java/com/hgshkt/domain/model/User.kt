package com.hgshkt.domain.model

data class User(
    val id: UserId,
    val name: String
)

data class UserId(
    val value: String
)
