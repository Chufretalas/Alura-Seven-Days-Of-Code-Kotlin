package components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import models.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridMovieCardsView(movies: List<Movie>) {
    LazyVerticalGrid(
        modifier = Modifier.padding(horizontal = 20.dp),
        cells = GridCells.Adaptive(200.dp),
        content = {
            items(movies.size) { index ->
                MovieCard(movies[index])
            }
        }
    )
}
