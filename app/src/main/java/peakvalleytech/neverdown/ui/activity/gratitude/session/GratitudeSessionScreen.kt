package peakvalleytech.neverdown.ui.activity.gratitude.session

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
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
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.ui.theme.colorPrimaryDark

@Composable
fun GratitudeSessionScreen(viewModel: GratitudeSessionViewModel) {
    val list: List<GratitudeItem> by viewModel.mItems.observeAsState(listOf())
    val (item, setItem) = remember {mutableStateOf(GratitudeItem())}
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(top = Dp(48f))) {
        item(itemText = item.name.toString())
        Button(onClick = {
            setItem(list.get(randomInt(0, list.size)))
        }) {
            Text("No")
        }
    }
}

fun randomInt(from: Int, to: Int): Int {
    return (100 * Math.random() % to as Int).toInt() + from
}
@Composable
fun prompt(promptText: String) {
    Text(promptText, modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = Dp(16f)), color = colorPrimaryDark, fontSize = 24.sp)
}

@Composable
fun item(itemText: String) {
    Text(itemText, modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = Dp(16f)), color = colorPrimaryDark, fontSize = 12.sp)

}

@Composable
@Preview
fun GratitudeSessionScreenPreview() {
    val list = mutableListOf<String>("car", "food", "bed", "dog")
    val (item, setItem) = remember {mutableStateOf(list.get(0))}
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(top = Dp(48f))) {
        item(itemText = item)
        Button(onClick = {
//            setItem(list.get(randomInt()))
        }) {
            Text("No")
        }
    }
}