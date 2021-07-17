package peakvalleytech.neverdown.ui.activity.gratitude

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import peakvalleytech.neverdown.ui.components.ActivityMenu
import peakvalleytech.neverdown.ui.components.button
import peakvalleytech.neverdown.ui.theme.colorPrimary

@Composable
fun GratitudeScreen(navController: NavHostController?) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(colorPrimary)) {
        ActivityMenu(
            title = "Gratitude", description = "Take some time to be grateful for the many blessings in your life. You'll feel better",
            menu = {
                button(text = "Manage List", onClick = {navController?.navigate("gratitude_list_screen")}, modifier = Modifier.fillMaxWidth())
                button(text = "Start Activity", onClick = { navController?.navigate("gratitude_session_screen") }, modifier = Modifier.fillMaxWidth())
            })
    }
}

@Preview
@Composable
fun GratitudeScreenPreview() {
    ActivityMenu(
        title = "Gratitude", description = "Take some time to be grateful for the many blessings in your life. You'll feel better",
        menu = {
            button(text = "Manage List", onClick = {}, modifier = Modifier.fillMaxWidth())
        })
}