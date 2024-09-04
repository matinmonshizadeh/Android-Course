package com.example.project.features.home_activity.domain.data.model.genres

import com.google.gson.annotations.SerializedName

data class GenreResponseItem(
    @SerializedName("id")
    val genreId: Int,
    @SerializedName("name")
    val genreName: String
)