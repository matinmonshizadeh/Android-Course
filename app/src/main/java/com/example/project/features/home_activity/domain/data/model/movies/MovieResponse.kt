package com.example.project.features.home_activity.domain.data.model.movies

data class MovieResponse(
    val `data`: List<MovieResponseItem>,
    val description: MovieResponseDescription,
    val metadata: MovieResponseMetadata,
    val status: Int
)