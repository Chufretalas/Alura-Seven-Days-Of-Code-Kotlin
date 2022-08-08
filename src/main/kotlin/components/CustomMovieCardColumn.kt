package components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import models.Movie

@Composable
fun CustomMovieCardColumn(contentList: List<Movie>, columnsPerRow: Int, messageWhenEmpty: String) {
    Column(
        modifier = Modifier.verticalScroll(state = ScrollState(0), enabled = true),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (contentList.isEmpty()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize().padding(vertical = 20.dp)
            ) {
                Text(messageWhenEmpty)
            }
        }
        var oldIndex = 0
        if (contentList.size > columnsPerRow) {
            for (newIndex in columnsPerRow..contentList.size step columnsPerRow) {
                println(contentList.subList(oldIndex, newIndex))
                LazyRow {
                    items(contentList.subList(oldIndex, newIndex)) { movie ->
                        MovieCard(movie)
                    }
                }
                if (contentList.size - 3 < newIndex) {
                    LazyRow {
                        items(contentList.subList(newIndex, contentList.size)) { movie ->
                            MovieCard(movie)
                        }
                    }
                    println(contentList.subList(newIndex, contentList.size))
                }
                oldIndex = newIndex
            }
        } else {
            LazyRow {
                items(contentList) { movie ->
                    MovieCard(movie)
                }
            }
        }
    }
}