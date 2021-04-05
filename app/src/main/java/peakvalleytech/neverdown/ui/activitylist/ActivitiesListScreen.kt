package peakvalleytech.neverdown.ui.activitylist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ActivitiesListScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
            Button(modifier = Modifier.fillMaxWidth(), onClick = { }) {
                Text("Gratitude")
            }

        Button(onClick = { /*TODO*/ }) {
            Text("Meditation")
        }
        Button(onClick = { /*TODO*/ }) {
            Text("Power Words")
        }
    }

}

@Preview
@Composable
fun ActivitiesListScreenPreview() {
    ActivitiesListScreen()
}