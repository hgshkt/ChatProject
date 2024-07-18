package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.UserSimpleData
import kotlinx.coroutines.flow.Flow

class GetUserFriendsUseCase(
    private val userRepository: UserRepository
) {
    fun execute(): Flow<UserSimpleData> {
        return userRepository.getCurrentUserFriends()
    }
}