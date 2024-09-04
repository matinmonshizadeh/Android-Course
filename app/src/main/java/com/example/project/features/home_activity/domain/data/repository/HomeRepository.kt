package com.example.project.features.home_activity.domain.data.repository

import com.example.project.features.home_activity.domain.data.model.genres.GenreResponse
import com.example.project.features.home_activity.domain.data.model.movies.MovieResponse
import com.example.project.shared_components.HomeAPIService

class HomeRepository(private val homeAPIService: HomeAPIService) {
    suspend fun getAllMoviesBasedOnGenreId(genreId: Int): Result<MovieResponse> {
        val response = homeAPIService.getAllMoviesBasedOnGenreId(genreId)
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Throwable("سرویس خطا داشت"))
        } else {
            Result.failure(Throwable("سرویس انجام نشد"))
        }
    }

    suspend fun getAllGenres(): Result<GenreResponse> {
        val response = homeAPIService.getAllGenres()
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.success(it)
            } ?: Result.failure(Throwable("سرویس خطا داشت"))
        } else {
            Result.failure(Throwable("سرویس انجام نشد"))
        }
    }
}