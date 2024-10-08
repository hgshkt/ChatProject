package com.hgshkt.data.repository.user

import com.hgshkt.data.filter.user.UserFilter
import com.hgshkt.data.mapper.toDomain
import com.hgshkt.data.mapper.toDomainSimple
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.data.repository.UserRepository.LoadUserState
import com.hgshkt.domain.model.UserSimpleData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepositoryImpl(
    private val remoteUserStorage: RemoteUserStorage,
    private val localUserStorage: LocalUserStorage,
    private val userFilter: UserFilter,
    private val currentUserId: String
) : UserRepository {
    override fun getCurrentUser(): Flow<LoadUserState> {
        return getUserById(currentUserId)
    }

    override fun getUserById(id: String) = flow {

        localUserStorage.getUserById(id).apply {
            if (success) {
                val successResult = LoadUserState.LocalSuccess(value!!.toDomainSimple())
                emit(successResult)
            } else {
                val failureResult = LoadUserState.LocalError(message = message)
                emit(failureResult)
            }
        }

        remoteUserStorage.getUserById(id).apply {
            if(success) {
                localUserStorage.saveUser(value!!)
                val successResult = LoadUserState.RemoteSuccess(value.toDomain())
                emit(successResult)
            } else {
                val failureResult = LoadUserState.RemoteError(message = message)
                emit(failureResult)
            }
        }
    }

    override suspend fun getFriends(): Resultc<List<UserSimpleData>> {
        remoteUserStorage.getFriendsFor(currentUserId).apply {
            if(success) {
                return Resultc.Success(value!!.map { user -> user.toDomainSimple() })
            }
        }
        return Resultc.Failure()
    }

    override suspend fun getRecommended(): Resultc<List<UserSimpleData>> {
        remoteUserStorage.getRecommended(currentUserId).apply {
            if(success) {
                return Resultc.Success(value!!.map { user -> user.toDomainSimple() })
            }
        }
        return Resultc.Failure()
    }

    override suspend fun getUsersByQuery(query: String): Resultc<List<UserSimpleData>> {
        remoteUserStorage.getUsersByQuery(query).apply {
            if(success) {
                return Resultc.Success(value!!.map { user -> user.toDomainSimple() })
            }
        }
        return Resultc.Failure()
    }

    override fun filterFriendsByQuery(query: String): List<UserSimpleData> {
        return userFilter.filterByQuery(query)
    }

    override suspend fun sendFriendInvite(id: String) {
        remoteUserStorage.sendFriendInvite(from = currentUserId, to = id)
    }

    override suspend fun deleteFriend(id: String) {
        remoteUserStorage.deleteFriend(currentUserId, id)
    }
}