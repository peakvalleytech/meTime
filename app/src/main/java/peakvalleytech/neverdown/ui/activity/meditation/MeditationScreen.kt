package peakvalleytech.neverdown.ui.activity.meditation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import peakvalleytech.neverdown.ui.components.StartScreen

@Composable
fun MeditationScreen(navController: NavHostController?) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        StartScreen(onStartActivity = { navController?.navigate("meditation_session_screen") },
            title = "Meditation", description = "Meditation is a great way to give the mind some rest ",
            menu = { /*TODO*/ })
    }
}

@Preview
@Composable
fun MeditationScreenPreview() {
    StartScreen(onStartActivity = { },
        title = "Meditation", description = "Meditation is a great way to give the mind some rest " +
                "and increase focus",
        menu = { /*TODO*/ })
}