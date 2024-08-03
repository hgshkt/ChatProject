package com.hgshkt.domain.model

data class User(
    val id: String,
    val name: String,
    val avatarUrl: String?,
    val backgroundUrl: String?,
    val friendList: List<String>,
    val incomingInvitations: List<String>,
    val outcomingInvitations: List<String>
)