package com.example.project.shared_components

import com.example.project.features.home_activity.domain.data.model.movies.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchAPIService {
    @GET("movies/5/{query}")
    suspend fun getMoviesBasedOnQuery(@Path("query") query: String): Response<MovieResponse>
}