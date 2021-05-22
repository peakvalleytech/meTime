package peakvalleytech.neverdown.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
//        Text(text)
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
            button()
        }
    }

}