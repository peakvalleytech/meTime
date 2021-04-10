package peakvalleytech.neverdown.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(
    content: @Composable() () -> Unit
) {
    val colors = darkColors(
        primary = Color.Magenta,
        primaryVariant = Color.Green,
        secondary = Color.Yellow
    )
    
    MaterialTheme(
        colors = colors,
        typography = androidx.compose.material.Typography(),
        shapes = Shapes(),
        content = content
    )
}