package peakvalleytech.neverdown.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppTopBar(onShowHelpDialogStateChange: (Boolean) -> Unit) {
    TopAppBar(title = {
        Text("Me Time", modifier = Modifier.padding(top = 8.dp))
    },
    actions = {
        IconButton(
            onClick = {
                onShowHelpDialogStateChange(true)
        }) {
            Icon(Icons.Filled.Help, "About")
        }
    })
}
