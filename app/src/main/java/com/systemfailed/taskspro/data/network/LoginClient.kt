package com.systemfailed.taskspro.data.network

import com.systemfailed.taskspro.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/35b5f77c-d901-4d4a-b72f-1d8c746fd9fc")
    suspend fun doLogin(): Response<LoginResponse>
}