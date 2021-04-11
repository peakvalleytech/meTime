package peakvalleytech.neverdown.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import peakvalleytech.neverdown.NeverDownApplication
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeScreen
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeViewModel
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeViewModelFactory
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionScreen
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionViewModel
import peakvalleytech.neverdown.ui.activity.meditation.MeditationScreen
import peakvalleytech.neverdown.ui.activity.meditation.MeditationViewModel
import peakvalleytech.neverdown.ui.activity.meditation.session.MediationSessionScreen
import peakvalleytech.neverdown.ui.activity.meditation.session.MeditationSessionViewModel
import peakvalleytech.neverdown.ui.activitylist.ActivitiesListScreen

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
           val gratitudeViewModel: GratitudeViewModel = GratitudeViewModel(gratitudeRepository = (context as NeverDownApplication).gratitudeRepository)
            GratitudeScreen(navController = navController, gratitudeViewModel)
        }
        composable("gratitude_session_screen") {
            val viewModel = GratitudeSessionViewModel(gratitudeRepository = (context as NeverDownApplication).gratitudeRepository)
            GratitudeSessionScreen(viewModel = viewModel)
        }
        composable("meditation_screen") { 
            MeditationScreen(navController = navController)
        }
        composable("meditation_session_screen") { 
            val viewModel = MeditationSessionViewModel()
            MediationSessionScreen(viewModel = viewModel)
        }
        
    }
}