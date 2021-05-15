package peakvalleytech.neverdown.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import peakvalleytech.neverdown.ui.theme.buttonColors

@Composable
fun button(text: String, onClick: () -> Unit, modifier: Modifier) {
    Button(onClick = {
        onClick()
    }, colors = buttonColors(), modifier = modifier) {
        Text(text)
    }
}