package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.User
import com.hgshkt.domain.data.Resultc

interface UserRepository {
    suspend fun getUserById(id: String): Resultc<User>
    fun getCurrentUserId(): String
    suspend fun getFriendsFor(id: String): Resultc<List<User>>
    suspend fun getRecommended(id: String): Resultc<List<User>>
    suspend fun getUsersByQuery(query: String): Resultc<List<User>>
}