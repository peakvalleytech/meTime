package peakvalleytech.neverdown.ui.activity.meditation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import peakvalleytech.neverdown.ui.components.ActivityMenu
import peakvalleytech.neverdown.ui.components.button
import peakvalleytech.neverdown.ui.theme.colorPrimary

@Composable
fun MeditationScreen(navController: NavHostController?) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(colorPrimary)) {
        ActivityMenu(
            title = "Meditation", description = "Meditation is a great way to give the mind some rest ",
            menu = listOf({
                button(text = "Start Activity", onClick = { navController?.navigate("meditation_session_screen") }, modifier = Modifier.fillMaxWidth())
            }))
    }
}

@Preview
@Composable
fun MeditationScreenPreview() {
    ActivityMenu(
        title = "Meditation", description = "Meditation is a great way to give the mind some rest " +
                "and increase focus",
        menu = listOf({ /*TODO*/ }))
}