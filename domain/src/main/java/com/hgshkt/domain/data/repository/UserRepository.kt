package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.User
import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.model.UserSimpleData

interface UserRepository {
    suspend fun getUserById(id: String): Resultc<User>
    fun getCurrentUserId(): String
    suspend fun getFriendsFor(id: String): Resultc<List<UserSimpleData>>
    suspend fun getRecommended(id: String): Resultc<List<UserSimpleData>>
    suspend fun getUsersByQuery(query: String): Resultc<List<UserSimpleData>>
}