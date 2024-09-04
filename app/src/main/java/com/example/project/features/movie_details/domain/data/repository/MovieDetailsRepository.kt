package com.example.project.features.movie_details.domain.data.repository

import com.example.project.features.movie_details.domain.data.model.movie_details.MovieDetailsResponse
import com.example.project.shared_components.MovieDetailsAPIService

class MovieDetailsRepository(private val movieDetailsAPIService: MovieDetailsAPIService) {
    suspend fun getMovieDetailsBasedOnId(movieId: Int): Result<MovieDetailsResponse> {
        val response = movieDetailsAPIService.getMovieDetailsBasedOnId(movieId)
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Throwable("سرویس خطا داشت"))
        } else {
            Result.failure(Throwable("سرویس انجام نشد"))
        }
    }

}