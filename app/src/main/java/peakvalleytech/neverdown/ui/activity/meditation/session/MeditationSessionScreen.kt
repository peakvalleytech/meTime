package peakvalleytech.neverdown.ui.activity.meditation.session

import android.graphics.drawable.DrawableWrapper
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import peakvalleytech.neverdown.ui.theme.colorPrimary
import peakvalleytech.neverdown.ui.theme.colorPrimaryDark

@Composable
fun MediationSessionScreen(viewModel: MeditationSessionViewModel) {
    val counter: Int by viewModel.mBreathCounter.observeAsState(1)
    val breathState: Int by viewModel.mBreathState.observeAsState(viewModel.INHALE_STATE)
    Content(counter.toString(), breathState, {viewModel.incrementCounter()})
}


val inhaleState = 1
val exhaleState = 2
@Composable
fun Content(counterText: String, breathState: Int, onCounterUpdate: () -> Unit) {
    onCounterUpdate()
    return Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement= Arrangement.Center,modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(colorPrimary)) {
        if (breathState == inhaleState) {
//            val alpha1: Float by animateFloatAsState(1.0f)
    //        AnimatedVisibility(visible = breathState == inhaleState, enter = fadeIn(), exit = fadeOut()) {
                text("Breath in")
           // }
        } else {
            text("")
        }
        text(counterText)

        if(breathState == exhaleState) {
//            val alpha2: Float by animateFloatAsState(0.1f)
            text("Breath out")
        } else {
            text("")
        }
    }
}

@Composable
fun text(text: String) {
    Text(text, color = colorPrimaryDark, fontSize = 48.sp,
    modifier = Modifier
        .fillMaxHeight(0.2f))
}
@Preview
@Composable
fun cardPreview() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = MaterialTheme.colors.surface,

        ) {

//            Column(d
//                modifier = Modifier
//                    .height(200.dp)
//                    .padding(16.dp),
//                verticalArrangement = Arrangement.Center,
//            ) {
//                Text(
//                    text = "This is a card view",
//                    style = MaterialTheme.typography.h4
//                )
//            }
        }
    }
}
//@ExperimentalAnimationApi
@Composable
@Preview
fun MeditationSessionScreenPreview() {
    Content("", 0, {})
}