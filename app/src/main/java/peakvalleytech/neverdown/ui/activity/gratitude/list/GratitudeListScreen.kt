package peakvalleytech.neverdown.ui.activity.gratitude.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.ui.activity.meditation.session.text
import peakvalleytech.neverdown.ui.theme.buttonColors
import peakvalleytech.neverdown.ui.theme.colorPrimary
import peakvalleytech.neverdown.ui.theme.colorPrimaryDark

@Composable
fun GratitudeListScreen(viewModel: GratitudeListViewModel?) {
    viewModel?.loadList()
    val list = viewModel?.listLiveData?.observeAsState(listOf())

    if (list != null) {
        Content(
            list = list.value!!,
            { Log.d("GratitudeListScreen", "Adding " + it)
                if (viewModel != null) {
                    viewModel.addItem(it)
                }
            },
            {
                Log.d("GratitudeListScreen", "Deleting " + it)
                if (viewModel != null) {
                    viewModel.deleteItem(it)
                }
            }
        )
    }
}
@SuppressLint("UnrememberedMutableState")
@Composable
fun Content(list: List<GratitudeItem>,
            onAddItem: (item: GratitudeItem) -> Unit,
            onDeleteItem: (item: GratitudeItem) -> Unit) {
    var hint = "Item you're grateful for"
    var textFieldState = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val icons = Icons.Filled
    val openDialog = remember {
        mutableStateOf(false)
    }
    Column(modifier =
    Modifier
        .fillMaxWidth()
        .background(colorPrimary)
    ) {

        LazyColumn(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.9f)
            .padding()) {
                    items(
                        list.size,
                        null
                    ) {
                        val item = list.get(it) as GratitudeItem
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("${item.name}", color = colorPrimaryDark, fontSize = 48.sp,
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .padding(8.dp))
                            IconButton(onClick = {onDeleteItem(item)}) {
                                Icon(
                                    Icons.Filled.Close,
                                    "contentDescription",
                                    tint = Color.White)
                            }
                        }
                        Divider()
                    }
//                Row {
////                    it.name?.let { it1 -> text(text = it1) }
//                }

        }
        if (openDialog.value) {
            AlertDialog(modifier = Modifier.padding(start = 24.dp, end = 24.dp),onDismissRequest= {
                openDialog.value = false
            },
            title = {Text("Add gratitude item")},
                text = {
                    Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceEvenly) {
                        BasicTextField(modifier = Modifier
                            .border(2.dp, colorPrimary)
                            .fillMaxWidth(.8f),
                            value = textFieldState.value,
                            onValueChange = {
                                textFieldState.value = it
//                    if (!isHint()) onInputChanged(textFieldState.text)
                            },
                            textStyle = MaterialTheme.typography.body1.copy(color = LocalContentColor.current),
                            cursorBrush = SolidColor(LocalContentColor.current),
//                            decorationBox = {
////                                Row(
////                                    modifier = Modifier.height(100.dp),
////                                    verticalAlignment = Alignment.CenterVertically
////                                ) {
////                                    it()
////                                    Spacer(
////                                        Modifier
////                                            .focusModifier()
////                                            .height(16.dp)
////                                    )
////                                }
//                            }
                        )
                    }


                },
                confirmButton = {Button({
                    openDialog.value = false
                    onAddItem(GratitudeItem(name = textFieldState.value.text))
                }) {Text("Confirm")} },
                dismissButton = {Button({openDialog.value = false}) {Text("Dismiss")} }
                )
        }

        Row(modifier = Modifier.fillMaxHeight(),verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.fillMaxWidth(.8f))
            Button(modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
                onClick = {
                    openDialog.value = true
                },
                colors = buttonColors()
            ) {
                Text("Add")
            }
        }
    }

}
@Preview
@Composable
fun GratitudeListScreenPreview() {
//    val items = mutableListOf<GratitudeItem>()
//    for (i in 1..50) {
//        items.add(GratitudeItem(i, "Item ${i}" ))
//    }
//    Content(list = items, {}, {})
}

@Preview
@Composable
fun ActivityFabPreview() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Column(modifier = Modifier.fillMaxHeight()) {
            
        }
        FloatingActionButton(
            modifier = Modifier.height(50.dp),
            onClick = {},
            shape = CircleShape,
        ) {

        }
    }
}