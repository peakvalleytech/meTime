package peakvalleytech.neverdown.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import peakvalleytech.neverdown.ui.theme.buttonColors

@Composable
fun button(text: String, onClick: () -> Unit, modifier: Modifier) {
    Button(onClick = {
        onClick()
    }, colors = buttonColors(), modifier = modifier) {
        Text(text)
    }
}