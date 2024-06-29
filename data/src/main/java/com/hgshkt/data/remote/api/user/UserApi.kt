package com.hgshkt.data.remote.api.user


import com.hgshkt.data.remote.api.user.reponse.LoginResponse
import com.hgshkt.data.remote.api.user.reponse.RegistrationResponse
import com.hgshkt.data.remote.api.user.reponse.UserResponse
import com.hgshkt.data.remote.api.user.request.LoginRequest
import com.hgshkt.data.remote.api.user.request.RegistrationRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface UserApi {
    @GET("")
    suspend fun getUserById(id: Int): UserResponse

    @POST("")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("")
    suspend fun register(@Body request: RegistrationRequest): RegistrationResponse
}