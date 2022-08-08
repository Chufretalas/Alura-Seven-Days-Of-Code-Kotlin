package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import extensions.formatRating
import http.fetchImageFromUrl
import models.Movie

@Composable
fun MovieCard(movie: Movie) {
    Box(
        modifier = Modifier.padding(8.dp)
            .widthIn(0.dp, 220.dp)
            .heightIn(0.dp, 280.dp)
            .clip(shape = RoundedCornerShape(3))
            .background(color = MaterialTheme.colors.onPrimary)
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("#${movie.rank} - ${movie.title}", fontSize = 16.sp)
            Image(
                bitmap = fetchImageFromUrl(movie.image),
                contentDescription = "it's morbing time",
                modifier = Modifier.padding(vertical = 3.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Sharp.Star,
                        contentDescription = "Star icon",
                        tint = Color.Yellow,
                        modifier = Modifier.size(20.dp)
                    )
                    Text("${movie.imDbRating.formatRating()}/10", fontSize = 16.sp)
                }
                Text(movie.year.toString())
            }
        }
    }
}


