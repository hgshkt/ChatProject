package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.repository.UserRepository

class GetRecommendedUsersUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(): UserRepository.UserListResponse {
        val id = userRepository.getCurrentUserId()
        return userRepository.getRecommended(id)
    }
}