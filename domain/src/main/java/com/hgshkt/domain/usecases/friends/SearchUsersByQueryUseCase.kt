package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.UserSimpleData
import kotlinx.coroutines.flow.Flow

class SearchUsersByQueryUseCase(
    private val userRepository: UserRepository
) {
    fun execute(query: String): Flow<UserSimpleData> {
        return userRepository.getUsersByQuery(query)
    }
}