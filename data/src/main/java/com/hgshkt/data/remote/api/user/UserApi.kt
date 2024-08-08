package com.hgshkt.data.remote.api.user


import com.hgshkt.data.remote.api.user.reponse.LoginResponse
import com.hgshkt.data.remote.api.user.reponse.ApiRegistrationResponse
import com.hgshkt.data.remote.api.user.reponse.ApiUserResponse
import com.hgshkt.data.remote.api.user.reponse.ApiUserListResponse
import com.hgshkt.data.remote.api.user.request.LoginRequest
import com.hgshkt.data.remote.api.user.request.ApiRegistrationRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface UserApi {
    @GET("")
    suspend fun getUserById(id: Int): ApiUserResponse

    @POST("")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("")
    suspend fun register(@Body request: ApiRegistrationRequest): ApiRegistrationResponse

    @GET("")
    suspend fun getFriendsFor(id: String): ApiUserListResponse

    @GET("")
    suspend fun getRecommended(id: String): ApiUserListResponse

    @GET("")
    suspend fun searchUsers(query: String): ApiUserListResponse

    @PUT("")
    suspend fun sendFriendInvite(from: String, to: String)

    @DELETE
    fun deleteFriend(currentUserId: String, deletedUserId: String)
}