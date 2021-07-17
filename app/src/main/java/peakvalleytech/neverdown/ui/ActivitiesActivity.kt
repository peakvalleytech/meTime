package peakvalleytech.neverdown.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import peakvalleytech.neverdown.ui.activitylist.ActivitiesListScreen
import peakvalleytech.neverdown.ui.theme.AppTheme
import peakvalleytech.neverdown.ui.theme.colorPrimary

class ActivitiesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                Scaffold(topBar = { TopAppBar(title = {Text("NeverDown")})}, content = {
                    Surface(modifier = Modifier.background(colorPrimary)) {

                        MyNavigation(context = applicationContext)
                    }
                })
            }
        }
    }
}