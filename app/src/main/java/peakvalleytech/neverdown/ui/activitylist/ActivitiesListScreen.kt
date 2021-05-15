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
import peakvalleytech.neverdown.ui.components.button
import peakvalleytech.neverdown.ui.components.card


@Composable
fun ActivitiesListScreen(navController: NavHostController) {
    val startButtonLabel = "Start"
    Column(modifier = Modifier.fillMaxWidth()) {
        card("Gratitude",
            {button(startButtonLabel, modifier = Modifier
            .fillMaxWidth()
            .padding(all = Dp(10f)), onClick = {
                navController.navigate("gratitude_screen")
            })}
        )

        card("Meditation",
            {button(startButtonLabel, onClick = {
                navController.navigate("meditation_screen")
                }, modifier = Modifier
                .fillMaxWidth()
                .padding(all = Dp(10f)))
            })
//
//        button("Values", onClick = { /*TODO*/ }, modifier = Modifier
//            .fillMaxWidth()
//            .padding(all = Dp(10f)))
    }
}

@Preview
@Composable
fun ActivitiesListScreenPreview() {
//    ActivitiesListScreen(()
}