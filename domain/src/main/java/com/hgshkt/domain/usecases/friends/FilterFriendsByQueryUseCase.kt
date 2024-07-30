package com.hgshkt.domain.usecases.friends

import com.hgshkt.domain.data.repository.UserRepository
import com.hgshkt.domain.model.UserSimpleData

class FilterFriendsByQueryUseCase(
    private val userRepository: UserRepository
) {
    fun execute(query: String): List<UserSimpleData> {
       return userRepository.filterFriendsByQuery(query)
    }
}