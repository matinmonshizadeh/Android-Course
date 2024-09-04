package com.example.project.features.home_activity.domain.data.model.genres

data class GenreResponse(
    val `data`: List<GenreResponseItem>,
    val description: GenreResponseDescription,
    val status: Int
)