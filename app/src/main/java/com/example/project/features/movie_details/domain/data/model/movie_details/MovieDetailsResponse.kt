package com.example.project.features.movie_details.domain.data.model.movie_details

data class MovieDetailsResponse(
    val `data`: MovieDetailsData,
    val description: MovieDetailsDescription,
    val status: Int
)