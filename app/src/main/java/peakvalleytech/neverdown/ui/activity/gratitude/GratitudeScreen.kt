package peakvalleytech.neverdown.ui.activity.gratitude

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
@Composable
fun GratitudeScreen(navController: NavHostController?, viewModel: GratitudeViewModel?) {
    Column(modifier = Modifier.padding(Dp(23f)).background(colorPrimary).fillMaxHeight().fillMaxWidth()) {
        Text("Gratitude", modifier = Modifier.fillMaxWidth().padding(bottom = Dp(16f)), color = colorPrimaryDark, fontSize = 24.sp
        )
        Text("Take some time to be grateful for the many blessings in your life. You'll feel better")
        Button(onClick = {
            navController?.navigate("gratitude_session_screen")
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Start session")
        }
    }
}

@Preview
@Composable
fun GratitudeScreenPreview() {
    GratitudeScreen(navController = null , viewModel = null)
}