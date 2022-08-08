package models

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: String,
    val rank: Int,
    val title: String,
    val fullTitle: String,
    val year: Int,
    val image: String,
    val crew: String,
    val imDbRating: Double,
    val imDbRatingCount: Int,
)