package peakvalleytech.neverdown.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import peakvalleytech.neverdown.ui.activitylist.ActivitiesListScreen
import peakvalleytech.neverdown.ui.components.AppTopBar
import peakvalleytech.neverdown.ui.theme.AppTheme
import peakvalleytech.neverdown.ui.theme.colorPrimary

class ActivitiesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SystemUi(windows = window) {
                val dialogState = remember {
                    mutableStateOf(false)
                }
                Scaffold(topBar = { AppTopBar {
                  dialogState.value = it
                }
                }, content = {
                    Surface(modifier = Modifier.background(colorPrimary)) {
                    if (dialogState.value) {
                        HelpDialog(dialogState, this)
                    }
                        MyNavigation(context = applicationContext)
                    }
                })
            }
        }
    }
}

@Composable
fun SystemUi(windows: Window, content: @Composable () -> Unit) =
    AppTheme {
        windows.statusBarColor = MaterialTheme.colors.primary.toArgb()
        windows.navigationBarColor = MaterialTheme.colors.primary.toArgb()

//        @Suppress("DEPRECATION")
//        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
//            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
//                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }
//
//        @Suppress("DEPRECATION")
//        if (MaterialTheme.colors.surface.luminance() > 0.5f) {
//            windows.decorView.systemUiVisibility = windows.decorView.systemUiVisibility or
//                    View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
//        }
        content()
    }


@Composable
fun HelpDialog(helpDialogState: MutableState<Boolean>, activity: ComponentActivity) {
    if(helpDialogState.value)
        AlertDialog(modifier = Modifier.padding(start = 24.dp, end = 24.dp),onDismissRequest = {
            helpDialogState.value = false
        },
            title = {
//                Row {
//                    Icon(Icons.Filled.Help, "About")
                    Text("About MeTime")
//                }
            },
            text = {
                Column {
                    Text("Why use MeTime?", fontWeight = FontWeight.Bold)
                    Text("\nMeTime helps you take better breaks so you can be more productive.")
                    Text("\nChoose from different activities that is scientifically proven to help you relax, destress, and calm your mind")
                    Text("\nSupport", fontWeight = FontWeight.Bold)
                    Text("\nDepending on you (the users), new activities may or may not be added.")
                    Text("\nPlease help support his app, by sharing and leaving a review.")
                    Text("\nLike this app?", fontWeight = FontWeight.Bold)
                    Text("\nPlease download my other apps, below:")
                }
            },
            confirmButton = {
                Button({
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setData(
                        Uri.parse("https://play.google.com/store/apps/developer?id=peakvalleytech")
                    )
                    activity.startActivity(intent)
                }) {
                    Text("Other Apps")
                }
            },
            dismissButton = {
                Button({
                    helpDialogState.value = false
                }) {
                    Text("Close")
                }
            }
        )
}