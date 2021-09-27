package peakvalleytech.neverdown.ui.activitylist

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import peakvalleytech.neverdown.ui.components.button
import peakvalleytech.neverdown.ui.components.card
import peakvalleytech.neverdown.ui.theme.colorPrimary


@Composable
fun ActivitiesListScreen(navController: NavHostController) {
    val startButtonLabel = "Start"
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(colorPrimary)) {
        card("Gratitude",
            {button(startButtonLabel, modifier = Modifier
                .fillMaxWidth(), onClick = {
                navController.navigate("gratitude_screen")
            })}
        )

        card("Meditation",
            {button(startButtonLabel, onClick = {
                navController.navigate("meditation_screen")
                }, modifier = Modifier
                .fillMaxWidth())
            })
//
//        button("Values", onClick = { /*TODO*/ }, modifier = Modifier
//            .fillMaxWidth()
//            .padding(all = Dp(10f)))
    }
}

@Composable
fun ActivityListItem() {
//    card
}

@Preview
@Composable
fun ActivitiesListScreenPreview() {
//    ActivitiesListScreen(()
}