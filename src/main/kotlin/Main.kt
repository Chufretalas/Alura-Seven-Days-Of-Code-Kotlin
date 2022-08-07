// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.MovieCard
import http.ImdbClient
import kotlinx.coroutines.launch
import models.Movie

@Composable
@Preview
fun App() {

    val coroutineScope = rememberCoroutineScope()

    val movies = remember {
        mutableStateOf<List<Movie>>(emptyList())
    }

    coroutineScope.launch {
        movies.value = ImdbClient.getTop250Movies().subList(0, 100)
    }

    val darkColors = darkColors(background = Color.DarkGray, onPrimary = Color(0xFF333333))
    MaterialTheme(colors = darkColors) {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.verticalScroll(state = ScrollState(0), enabled = true),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (movies.value.isEmpty()) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize().padding(vertical = 20.dp)
                    ) {
                        Text("Fetching movies...")
                    }
                }
                var oldIndex = 0
                if (movies.value.size > 3) {
                    for (newIndex in 3..movies.value.size step 3) {
                        println(movies.value.subList(oldIndex, newIndex))
                        LazyRow {
                            items(movies.value.subList(oldIndex, newIndex)) { movie ->
                                MovieCard(movie, MaterialTheme)
                            }
                        }
                        if (movies.value.size - 3 < newIndex) {
                            LazyRow {
                                items(movies.value.subList(newIndex, movies.value.size)) { movie ->
                                    MovieCard(movie, MaterialTheme)
                                }
                            }
                            println(movies.value.subList(newIndex, movies.value.size))
                        }
                        oldIndex = newIndex
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
