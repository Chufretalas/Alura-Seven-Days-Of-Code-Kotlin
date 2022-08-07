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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import extensions.formatRating
import http.fetchImageFromUrl
import models.Movie
import java.net.URL
import kotlin.math.floor
import kotlin.math.roundToInt

@Composable
fun MovieCard(movie: Movie, MaterialTheme: MaterialTheme) {
    Box(
        modifier = Modifier.padding(8.dp)
            .widthIn(0.dp, 200.dp)
            .heightIn(0.dp, 500.dp)
            .clip(shape = RoundedCornerShape(3))
            .background(color = MaterialTheme.colors.onPrimary)
            .padding(5.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(movie.title)
            Image(
                bitmap = fetchImageFromUrl(movie.posterUrl),
                contentDescription = "it's morbing time",
                modifier = Modifier.width(200.dp).padding(vertical = 5.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(200.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Sharp.Star,
                        contentDescription = "Star icon",
                        tint = Color.Yellow,
                        modifier = Modifier.size(20.dp)
                    )
                    Text("${movie.rating.formatRating()}/10")
                }
                Text(movie.year.toString())
            }
        }
    }
}


