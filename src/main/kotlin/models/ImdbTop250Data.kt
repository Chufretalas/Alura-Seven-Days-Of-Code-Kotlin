package models

import kotlinx.serialization.Serializable

@Serializable
data class ImdbTop250Data(val items: List<Movie>, val errorMessage: String)