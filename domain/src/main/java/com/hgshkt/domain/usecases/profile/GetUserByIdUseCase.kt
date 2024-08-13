package com.hgshkt.domain.usecases.profile

import com.hgshkt.domain.data.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {
    fun execute(
        id: String
    ): Flow<UserRepository.LoadUserState> {
        return userRepository.getUserById(id)
    }
}