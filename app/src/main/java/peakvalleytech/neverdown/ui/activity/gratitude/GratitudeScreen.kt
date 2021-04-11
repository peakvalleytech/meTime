package peakvalleytech.neverdown.ui.activity.gratitude

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import peakvalleytech.neverdown.ui.theme.colorPrimary
import peakvalleytech.neverdown.ui.theme.colorPrimaryDark
import androidx.navigation.compose.navigate
import peakvalleytech.neverdown.ui.activity.gratitude.session.content
import peakvalleytech.neverdown.ui.activity.gratitude.session.randomInt
import peakvalleytech.neverdown.ui.components.StartScreen
import peakvalleytech.neverdown.ui.theme.colorAccent

@Composable
fun GratitudeScreen(navController: NavHostController?, viewModel: GratitudeViewModel?) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        StartScreen(onStartActivity = { navController?.navigate("gratitude_session_screen") },
            title = "Gratitude", description = "Take some time to be grateful for the many blessings in your life. You'll feel better",
            menu = { /*TODO*/ })
    }
}

@Preview
@Composable
fun GratitudeScreenPreview() {
    StartScreen(onStartActivity = { },
        title = "Gratitude", description = "Take some time to be grateful for the many blessings in your life. You'll feel better",
        menu = { /*TODO*/ })
}