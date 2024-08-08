package com.hgshkt.domain.usecases.profile

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.data.repository.UserRepository.UserResponse

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(
        id: String
    ): UserResponse {
        return userRepository.getCurrentUser(id)
    }
}