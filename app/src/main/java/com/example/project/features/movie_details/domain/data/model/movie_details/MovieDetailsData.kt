package com.example.project.features.movie_details.domain.data.model.movie_details

import com.google.gson.annotations.SerializedName

data class MovieDetailsData(
    @SerializedName("actors")
    val movieDetailsActors: String,
    @SerializedName("awards")
    val movieDetailsAwards: String,
    @SerializedName("country")
    val movieDetailsCountry: String,
    @SerializedName("director")
    val movieDetailsDirector: String,
    @SerializedName("genres")
    val movieDetailsGenres: List<String>,
    @SerializedName("id")
    val movieDetailsId: Int,
    @SerializedName("images")
    val movieDetailsImages: List<String>,
    @SerializedName("imdb_id")
    val movieDetailsImdbId: String,
    @SerializedName("imdb_rating")
    val movieDetailsImdbRating: String,
    @SerializedName("imdb_votes")
    val movieDetailsImdbVotes: String,
    @SerializedName("metascore")
    val movieDetailsMetascore: String,
    @SerializedName("plot")
    val movieDetailsSummary: String,
    @SerializedName("poster")
    val movieDetailsPoster: String,
    @SerializedName("rated")
    val movieDetailsRated: String,
    @SerializedName("released")
    val movieDetailsReleased: String,
    @SerializedName("runtime")
    val movieDetailsRuntime: String,
    @SerializedName("title")
    val movieDetailsTitle: String,
    @SerializedName("type")
    val movieDetailsType: String,
    @SerializedName("writer")
    val movieDetailsWriter: String,
    @SerializedName("year")
    val movieDetailsYear: String
)