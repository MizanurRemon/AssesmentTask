package com.technonext.assesmenttask.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.technonext.assesmenttask.home.bottom_nav_screens.SettingsScreen
import com.technonext.assesmenttask.home.bottom_nav_screens.FavoritesScreen
import com.technonext.feed_presentation.FeedScreen
import com.technonext.designsystem.BottomNavRoute

@Composable
fun BottomNavigationGraph(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = BottomNavRoute.FEED
    ) {

        composable (BottomNavRoute.FEED) {
            //val viewModel = hiltViewModel<FeedViewModel>()
            FeedScreen()
        }

        composable(BottomNavRoute.FAVORITES) {
            FavoritesScreen()
        }

        composable(BottomNavRoute.SETTINGS) {
            SettingsScreen()
        }

    }
}
