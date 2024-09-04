package com.example.project.features.search_activity.repository

import com.example.project.features.home_activity.domain.data.model.movies.MovieResponse
import com.example.project.shared_components.SearchAPIService

class SearchRepository(private val searchAPIService: SearchAPIService) {
    suspend fun getMoviesBasedOnQuery(query: String): Result<MovieResponse> {
        val response = searchAPIService.getMoviesBasedOnQuery(query)
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Throwable("سرویس خطا داشت"))
        } else {
            Result.failure(Throwable("سرویس انجام نشد"))
        }
    }

}