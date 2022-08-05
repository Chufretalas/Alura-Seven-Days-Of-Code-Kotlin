// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import http.fetchImageFromUrl
import java.net.URL

@Composable
@Preview
fun App() {
    val imageUrl = URL("https://pbs.twimg.com/media/FFyT_6GVgAAGgrG?format=jpg&name=900x900")
    MaterialTheme {
        Column {
            Text("Morbius")
            Image(
                bitmap = fetchImageFromUrl(imageUrl),
                contentDescription = "it's morbing time",
                modifier = Modifier.height(500.dp)
            )
            Text("Nota: 10 morbillion - Ano: 2022")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
