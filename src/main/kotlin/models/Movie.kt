package models

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val rank: Int,
    val title: String,
    val year: Int,
    val image: String,
    val imDbRating: Double,
)