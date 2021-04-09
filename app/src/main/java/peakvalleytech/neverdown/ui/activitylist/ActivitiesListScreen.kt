package peakvalleytech.neverdown.ui.activitylist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate


@Composable
fun ActivitiesListScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(all = Dp(10f)), onClick = {
                navController.navigate("gratitude_screen")
        }) {
            Text("Gratitude")
        }

        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(all = Dp(10f))) {
            Text("Meditation")
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(all = Dp(10f))) {
            Text("Power Words")
        }
    }

}

@Preview
@Composable
fun ActivitiesListScreenPreview() {
//    ActivitiesListScreen(navController)
}