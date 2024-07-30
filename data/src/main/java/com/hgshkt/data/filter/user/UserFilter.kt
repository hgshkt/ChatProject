package com.hgshkt.data.filter.user

import com.hgshkt.domain.model.UserSimpleData

interface UserFilter {
    fun filterByQuery(query: String): List<UserSimpleData>
}