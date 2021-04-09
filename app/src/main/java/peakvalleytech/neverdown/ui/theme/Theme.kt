package peakvalleytech.neverdown.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Typography

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