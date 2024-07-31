package com.hgshkt.domain.data.repository

import com.hgshkt.domain.model.User
import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.model.UserSimpleData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserById(id: String): Flow<LoadUserState>
    fun getCurrentUserId(): String
    suspend fun getFriendsFor(id: String): Resultc<List<UserSimpleData>>
    suspend fun getRecommended(id: String): Resultc<List<UserSimpleData>>
    suspend fun getUsersByQuery(query: String): Resultc<List<UserSimpleData>>
    fun filterFriendsByQuery(query: String): List<UserSimpleData>
    suspend fun sendFriendRequest(from: String, to: String)

    sealed class LoadUserState {
        data class LocalSuccess(val simpleData: UserSimpleData): LoadUserState()
        data class LocalError(val message: String): LoadUserState()
        data class RemoteSuccess(val user: User): LoadUserState()
        data class RemoteError(val message: String): LoadUserState()
    }
}