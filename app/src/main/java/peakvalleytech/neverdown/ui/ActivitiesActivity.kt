package peakvalleytech.neverdown.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import peakvalleytech.neverdown.ui.activitylist.ActivitiesListScreen
import peakvalleytech.neverdown.ui.theme.AppTheme

@AndroidEntryPoint
class ActivitiesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activities_activity)


        setContent {
            AppTheme {
                MyNavigation(context = applicationContext, viewModel())
            }
        }
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.fragment_host, ActivitiesListFragment())

//        transaction.commit()

    }
}