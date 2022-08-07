package models

import kotlinx.serialization.Serializable

@Serializable
data class Movies(val items: List<Movie>)