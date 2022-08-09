import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.CentralizedBox
import components.GridMovieCardsView
import http.ImdbClient
import kotlinx.coroutines.launch
import models.Movie

@Composable
@Preview
fun App() {

    val coroutineScope = rememberCoroutineScope()

    var movies by remember {
        mutableStateOf(emptyList<Movie>())
    }

    var waitingForMovies by remember { mutableStateOf(true) }
    var apiErrorMessage by remember { mutableStateOf("") }

    coroutineScope.launch {
        try {
            val response = ImdbClient.getTop250Movies()
            waitingForMovies = false
            apiErrorMessage = response.errorMessage
            movies = response.items
        } catch (e: Exception) {
            waitingForMovies = false
            apiErrorMessage = "$e has occurred"
        }

    }

    val darkColors = darkColors(background = Color.DarkGray, onPrimary = Color(0xFF333333))
    MaterialTheme(colors = darkColors) {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            if (waitingForMovies) {
                CentralizedBox { Text("Fetching movies...") }
            } else {
                if (apiErrorMessage == "") {
                    GridMovieCardsView(movies)
                } else {
                    CentralizedBox {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Could not get data from network.")
                            Text("Error message: $apiErrorMessage")
                        }
                    }
                }
            }

        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
