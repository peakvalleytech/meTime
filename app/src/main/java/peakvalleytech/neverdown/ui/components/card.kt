package peakvalleytech.neverdown.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import peakvalleytech.neverdown.ui.theme.colorPrimary
import peakvalleytech.neverdown.ui.theme.colorPrimaryDark

@Composable
fun card(title: String, button: @Composable () -> Unit) {
    androidx.compose.material.Card(
        modifier = Modifier.padding(16.dp), shape = RoundedCornerShape(8.dp),
        backgroundColor = colorPrimary
    ) {
        Column(
            modifier = Modifier
                .height(200.dp)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(16.dp))
            button()
        }
    }

}