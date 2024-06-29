package com.hgshkt.domain.usecases

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.data.repository.UserRepository.GetUserByIdResponse
import com.hgshkt.domain.data.repository.UserRepository.UserId

class GetUserByIdUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(
        id: UserId
    ): GetUserByIdResponse {
        return userRepository.getUserById(id)
    }
}