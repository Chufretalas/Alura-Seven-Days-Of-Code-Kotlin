// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.MovieCard
import java.net.URL

@Composable
@Preview
fun App() {
    val imageUrl = URL("https://pbs.twimg.com/media/FFyT_6GVgAAGgrG?format=jpg&name=900x900")
    val darkColors = darkColors(background = Color.DarkGray, onPrimary = Color(0xFF333333))
    MaterialTheme(colors = darkColors) {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
            Column {
                Row {
                    MovieCard(imageUrl, MaterialTheme)
                    MovieCard(imageUrl, MaterialTheme)
                    MovieCard(imageUrl, MaterialTheme)
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
