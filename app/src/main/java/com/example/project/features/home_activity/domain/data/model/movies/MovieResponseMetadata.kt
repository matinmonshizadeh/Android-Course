package com.example.project.features.home_activity.domain.data.model.movies

data class MovieResponseMetadata(
    val current_page: Int,
    val has_next: Boolean,
    val has_prev: Boolean,
    val page_count: Int,
    val per_page: Int,
    val total_count: Int
)