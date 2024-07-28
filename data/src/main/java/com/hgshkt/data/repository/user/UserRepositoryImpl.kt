package com.hgshkt.data.repository.user

import com.hgshkt.data.mapper.toDomain
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.User

class UserRepositoryImpl(
    private val remoteUserStorage: RemoteUserStorage,
    private val localUserStorage: LocalUserStorage
) : UserRepository {

    override suspend fun getUserById(id: String): Resultc<User> {
        // TODO() local and remote division
        // if user saved locally,return it
        localUserStorage.getUserById(id).apply {
            if (success) {
                return Resultc.Success(value!!.toDomain())
            }
        }

        // in other case fetch value from remote storage
        remoteUserStorage.getUserById(id).apply {
            if(success) {
                localUserStorage.saveUser(value!!)
                return Resultc.Success(value.toDomain())
            }
        }
        return Resultc.Failure()
    }

    override fun getCurrentUserId(): String {
        return localUserStorage.getCurrentUserId()
    }

    override suspend fun getFriendsFor(id: String): Resultc<List<User>> {
        remoteUserStorage.getFriendsFor(id).apply {
            if(success) {
                return Resultc.Success(value!!.map { user -> user.toDomain() })
            }
        }
        return Resultc.Failure()
    }

    override suspend fun getRecommended(id: String): Resultc<List<User>> {
        remoteUserStorage.getRecommended(id).apply {
            if(success) {
                return Resultc.Success(value!!.map { user -> user.toDomain() })
            }
        }
        return Resultc.Failure()
    }

    override suspend fun getUsersByQuery(query: String): Resultc<List<User>> {
        TODO("Not yet implemented")
    }
}