package peakvalleytech.neverdown.ui

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import peakvalleytech.neverdown.NeverDownApplication
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeRepository
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeScreen
import peakvalleytech.neverdown.ui.activity.gratitude.list.GratitudeListScreen
import peakvalleytech.neverdown.ui.activity.gratitude.list.GratitudeListViewModel
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionScreen
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionViewModel
import peakvalleytech.neverdown.ui.activity.meditation.MeditationScreen
import peakvalleytech.neverdown.ui.activity.meditation.session.MediationSessionScreen
import peakvalleytech.neverdown.ui.activity.meditation.session.MeditationSessionViewModel
import peakvalleytech.neverdown.ui.activitylist.ActivitiesListScreen
import javax.inject.Inject

@Composable
fun MyNavigation(context: Context) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "activities_list_screen"
    ) {
        composable("activities_list_screen") {
            ActivitiesListScreen(navController = navController)
        }
        composable("gratitude_screen") {
            GratitudeScreen(navController = navController)
        }
        composable("gratitude_session_screen") {
            val gratitudeSessionViewModel =
                GratitudeSessionViewModel(gratitudeRepository = (context as NeverDownApplication).gratitudeRepository)
            GratitudeSessionScreen(viewmodel = gratitudeSessionViewModel)
        }
        composable("meditation_screen") { 
            MeditationScreen(navController = navController)
        }
        composable("meditation_session_screen") { 
            val viewModel = MeditationSessionViewModel()
            viewModel.startCounter()
            MediationSessionScreen(viewModel = viewModel)
        }
        composable("gratitude_list_screen") {
            val viewModel = GratitudeListViewModel(gratitudeRepository = (context as NeverDownApplication).gratitudeRepository)
            GratitudeListScreen(viewModel = viewModel)
        }
    }
}