package com.hgshkt.data.repository.user

import com.hgshkt.data.mapper.toDomain
import com.hgshkt.data.mapper.toDomainResult
import com.hgshkt.data.mapper.toStorage
import com.hgshkt.data.storage.user.interfaces.LocalUserStorage
import com.hgshkt.data.storage.user.interfaces.RemoteUserStorage
import com.hgshkt.domain.data.Result
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.User

class UserRepositoryImpl(
    private val remoteUserStorage: RemoteUserStorage,
    private val localUserStorage: LocalUserStorage
) : UserRepository {

    override suspend fun getUserById(id: String): Result<User> {
        // if user saved locally,return it
        val localUser = localUserStorage.getUserById(id)
        localUser?.let {
            return Result.Success(it.toDomain())
        }
        // in other case fetch value from remote storage
        val response = remoteUserStorage.getUserById(id).toDomainResult()
        // save it locally if not null
        response.value?.let {
            localUserStorage.saveUser(it.toStorage())
        }
        return response
    }

    override fun getCurrentUserId(): String {
        return localUserStorage.getCurrentUserId()
    }
}