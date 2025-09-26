package com.technonext.assesmenttask.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.technonext.assesmenttask.navigations.BottomNavigationGraph
import com.technonext.designsystem.BOTTOM_NAVIGATION_ITEM
import com.technonext.designsystem.components.CustomNavigationItem
import com.technonext.designsystem.components.TopAppBar
import com.technonext.designsystem.r
import com.technonext.designsystem.theme.ThemeMode
import com.technonext.common.R as CommonR

@Composable
fun HomeScreen(
    state: HomeState,
    themeMode: ThemeMode
) {
    val bottomNavController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar()
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.background
            ) {
                val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
                val currentDestination: NavDestination? = navBackStackEntry?.destination
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    BOTTOM_NAVIGATION_ITEM.forEach { item ->

                        CustomNavigationItem(
                            modifier = Modifier.weight(1f),
                            onClick = {
                                bottomNavController.navigate(item.route) {
                                    popUpTo(bottomNavController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            title = item.title,
                            icon = item.icon,
                            isSelected = currentDestination?.route == item.route,
                            isFavorite = item.title == CommonR.string.favorites && state.favoriteCount > 0,
                            favoriteCount = state.favoriteCount
                        )

                    }

                }
            }
        },
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(vertical = 8.r())
        ) {
            BottomNavigationGraph(
                navController = bottomNavController,
                themeMode = themeMode
            )
        }
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun PreviewHomeScreen() {
    var themeMode by rememberSaveable { mutableStateOf(ThemeMode.SYSTEM) }
    HomeScreen(
        state = HomeState(),
        themeMode = themeMode
    )
}