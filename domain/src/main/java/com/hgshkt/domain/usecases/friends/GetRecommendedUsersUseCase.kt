package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.Resultc
import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.User
import com.hgshkt.domain.model.UserSimpleData

class GetRecommendedUsersUseCase(
    private val userRepository: UserRepository
) {
    suspend fun execute(): Resultc<List<UserSimpleData>> {
        return userRepository.getRecommended()
    }
}