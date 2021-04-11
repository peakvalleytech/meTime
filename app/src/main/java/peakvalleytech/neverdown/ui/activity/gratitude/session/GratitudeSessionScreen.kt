package peakvalleytech.neverdown.ui.activity.gratitude.session

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue

import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.ui.components.button
import peakvalleytech.neverdown.ui.theme.buttonColors
import peakvalleytech.neverdown.ui.theme.colorAccent
import peakvalleytech.neverdown.ui.theme.colorPrimary
import peakvalleytech.neverdown.ui.theme.colorPrimaryDark

@Composable
fun GratitudeSessionScreen(viewModel: GratitudeSessionViewModel) {
    val list: List<GratitudeItem> by viewModel.mItems.observeAsState(listOf())
    val (item, setItem) = remember {mutableStateOf(GratitudeItem())}
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        content(item.name.toString()) {
            setItem(list.get(randomInt(0, list.size)))
        }
    }
}

fun randomInt(from: Int, to: Int): Int {
    return (100 * Math.random() % to as Int).toInt() + from
}

@Composable
fun content(itemName: String, onNextListener: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(Dp(16f))
        .background(colorPrimary)) {
        prompt("Are you grateful for ...")
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f), verticalAlignment = Alignment.CenterVertically) {
            item(itemText = itemName.toString())
        }
        Row(verticalAlignment = Alignment.Bottom,modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight()
            .border(width = Dp(1f), color = Color.Yellow)) {
            button("Yes", onNextListener, modifier = Modifier
                .fillMaxWidth(0.5f)
                .background(
                    colorAccent
                ))
            button("No", onNextListener, modifier = Modifier
                .fillMaxWidth(1f)
                .background(colorAccent))
        }
    }
}
@Composable
fun prompt(promptText: String) {
    Text(promptText, modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = Dp(16f)), color = colorPrimaryDark, fontSize = 36.sp)
}

@Composable
fun item(itemText: String) {
    Text(
        itemText, modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Dp(16f)), color = colorPrimaryDark, fontSize = 24.sp,
        textAlign = TextAlign.Center
    )

}



@Composable
@Preview
fun GratitudeSessionScreenPreview() {
    val list = mutableListOf<String>("car", "food", "bed", "dog")
    val (item, setItem) = remember {mutableStateOf(list.get(0))}
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(top = Dp(48f))) {
        content(list[0]) {
            setItem(list.get(randomInt(0, list.size)))
        }
    }
}