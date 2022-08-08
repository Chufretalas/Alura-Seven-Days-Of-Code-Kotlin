package http

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import models.Movie
import models.ImdbTop250Data


object ImdbClient {

    private val apiKey: String = "your_key"; //TODO: put your imdb api key here

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = false
            })
        }
    }

    suspend fun getTop250Movies(): List<Movie> {
        val response: ImdbTop250Data =
            client.get("https://imdb-api.com/en/API/Top250Movies/$apiKey")
                .body()
        return response.items
    }
}