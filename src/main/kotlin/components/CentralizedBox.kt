package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CentralizedBox(child: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize().padding(vertical = 20.dp),
        contentAlignment = Alignment.Center,
    ) {
        child()
    }
}