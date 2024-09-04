package com.example.project.shared_components

import com.example.project.features.signup_activity.domain.data.model.user.SignUpResponse
import com.example.project.features.signup_activity.domain.data.model.user.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpAPIService {
    @POST("register")
    suspend fun setUser(@Body user: User): Response<SignUpResponse>
}
