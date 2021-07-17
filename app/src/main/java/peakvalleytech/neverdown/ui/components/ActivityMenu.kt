package peakvalleytech.neverdown.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.navigate
import peakvalleytech.neverdown.ui.theme.colorAccent
import peakvalleytech.neverdown.ui.theme.colorPrimary
import peakvalleytech.neverdown.ui.theme.colorPrimaryDark

/**
 * @param onStartActivity a listner that is called to start activity
 * @param menu a composable that displays a menu of actions specific to calling composeable
 */
@Composable
fun ActivityMenu(title: String, description: String, menu: @Composable ()-> Unit) {
    Column(modifier = Modifier
        .padding(Dp(16f))
        .background(colorPrimary)
        .fillMaxHeight()
        .fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxHeight(0.5f)) {
            Text(title, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Dp(16f)), color = colorPrimaryDark, fontSize = 24.sp
            )
            Text(description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = Dp(16f)), color = colorPrimaryDark, fontSize = 24.sp)
        }
        Row(modifier = Modifier
            .fillMaxHeight(0.2f),
            verticalAlignment = Alignment.Top) {
            Column(modifier = Modifier.fillMaxWidth()) {
                menu()
            }

        }
//        Spacer(modifier = Mo)

    }
}

@Preview
@Composable
fun ActivityMenuPreview() {
    ActivityMenu(title = "Activity title", description = "Activity description." ) {
        button(text = "Manage List", onClick = {}, modifier = Modifier.fillMaxWidth())
        button(text = "Start Activity", onClick = {}, modifier = Modifier.fillMaxWidth())
    }
}