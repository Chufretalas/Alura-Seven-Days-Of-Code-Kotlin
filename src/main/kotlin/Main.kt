// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import http.ImdbClient
import kotlinx.coroutines.launch
import models.Movie
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import components.CustomMovieCardColumn

@Composable
@Preview
fun App() {

    val coroutineScope = rememberCoroutineScope()

    var movies by remember {
        mutableStateOf(emptyList<Movie>())
    }

    coroutineScope.launch {
        movies = ImdbClient.getTop250Movies().subList(0, 100)
    }

    val darkColors = darkColors(background = Color.DarkGray, onPrimary = Color(0xFF333333))
    MaterialTheme(colors = darkColors) {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            CustomMovieCardColumn(movies, 3,"Fetching movies...")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
