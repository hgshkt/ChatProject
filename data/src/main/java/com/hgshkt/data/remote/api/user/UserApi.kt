package com.hgshkt.data.remote.api.user


import com.hgshkt.data.remote.api.user.model.UserResponse
import retrofit2.http.GET


interface UserApi {
    @GET("")
    fun getUserById(id: Int): UserResponse
}