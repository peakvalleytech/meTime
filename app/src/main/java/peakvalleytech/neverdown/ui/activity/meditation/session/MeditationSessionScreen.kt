package peakvalleytech.neverdown.ui.activity.meditation.session

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import peakvalleytech.neverdown.ui.theme.colorPrimary
import peakvalleytech.neverdown.ui.theme.colorPrimaryDark

@Composable
fun MediationSessionScreen(viewModel: MeditationSessionViewModel) {
    val counter: Int by viewModel.mBreathCounter.observeAsState(0)
    viewModel.startCounter()
    Content(counterText = counter.toString())
}



@Composable
fun Content(counterText: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement= Arrangement.Center,modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(colorPrimary)) {
        text("Breath in")
        text(counterText)
        text("Breath out")
    }
}

@Composable
fun text(text: String) {
    Text(text, color = colorPrimaryDark, fontSize = 48.sp,
    modifier = Modifier.fillMaxHeight(0.2f))
}

@Preview
@Composable
fun MeditationSessionScreenPreview() {
    Content("")
}