package com.example.project.features.home_activity.domain.data.model.movies

import com.google.gson.annotations.SerializedName

data class MovieResponseItem(
    @SerializedName("country")
    val movieCountry: String,
    @SerializedName("genres")
    val movieGenres: List<String>,
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("images")
    val movieImages: List<String>,
    @SerializedName("imdb_rating")
    val movieRating: String,
    @SerializedName("poster")
    val moviePoster: String,
    @SerializedName("title")
    val movieTitle: String,
    @SerializedName("year")
    val movieYear: String
)