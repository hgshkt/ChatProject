package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.data.repository.UserRepository.GetUserByIdResponse

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(
        id: String
    ): GetUserByIdResponse {
        return userRepository.getUserById(id)
    }
}