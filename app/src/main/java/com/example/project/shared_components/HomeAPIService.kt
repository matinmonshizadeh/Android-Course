package com.example.project.shared_components

import com.example.project.features.home_activity.domain.data.model.genres.GenreResponse
import com.example.project.features.home_activity.domain.data.model.movies.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeAPIService {
    @GET("genres")
    suspend fun getAllGenres(): Response<GenreResponse>

    @GET("genres/{genreId}/movies")
    suspend fun getAllMoviesBasedOnGenreId(@Path("genreId") genreId: Int): Response<MovieResponse>
}