package com.technonext.assesmenttask.navigations

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.technonext.assesmenttask.home.bottom_nav_screens.SettingsScreen
import com.technonext.feed_presentation.favorite.FavoritesScreen
import com.technonext.feed_presentation.feed.FeedScreen
import com.technonext.designsystem.BottomNavRoute
import com.technonext.feed_presentation.favorite.FavoriteViewModel
import com.technonext.feed_presentation.feed.FeedViewModel

@Composable
fun BottomNavigationGraph(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = BottomNavRoute.FEED
    ) {

        composable (BottomNavRoute.FEED) {
            val viewModel = hiltViewModel<FeedViewModel>()
            FeedScreen(
                state = viewModel.state,
                onEvent = viewModel::onEvent,
                loadNextPage = viewModel::loadNextPage
            )
        }

        composable(BottomNavRoute.FAVORITES) {
            val viewModel = hiltViewModel<FavoriteViewModel>()
            FavoritesScreen(
                state = viewModel.state,
                onEvent = viewModel::onEvent,
            )
        }

        composable(BottomNavRoute.SETTINGS) {
            SettingsScreen()
        }

    }
}
