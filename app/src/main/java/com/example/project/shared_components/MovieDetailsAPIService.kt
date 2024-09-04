package com.example.project.shared_components

import com.example.project.features.movie_details.domain.data.model.movie_details.MovieDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsAPIService {
    @GET("movie/{movieId}")
    suspend fun getMovieDetailsBasedOnId(@Path("movieId") movieId: Int): Response<MovieDetailsResponse>
}