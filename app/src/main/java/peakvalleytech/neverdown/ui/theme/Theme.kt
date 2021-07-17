package peakvalleytech.neverdown.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppTheme(
    content: @Composable() () -> Unit
) {
    val colors = lightColors(
        primary = colorPrimary,
        primaryVariant = colorPrimaryDark,
        secondary = colorAccent
    )
    
    MaterialTheme(
        colors = colors,
        typography = androidx.compose.material.Typography(),
        shapes = Shapes(),
        content = content
    )
}