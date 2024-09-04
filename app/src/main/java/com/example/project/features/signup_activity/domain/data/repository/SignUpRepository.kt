package com.example.project.features.signup_activity.domain.data.repository

import com.example.project.features.signup_activity.domain.data.model.user.SignUpResponse
import com.example.project.features.signup_activity.domain.data.model.user.User
import com.example.project.shared_components.SignUpAPIService

class SignUpRepository(private val signUpAPIService: SignUpAPIService) {
    suspend fun setUser(user: User): Result<SignUpResponse> {
        val response = signUpAPIService.setUser(user)
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Throwable("سرویس خطا داشت"))
        } else {
            Result.failure(Throwable("سرویس انجام نشد"))
        }
    }
}