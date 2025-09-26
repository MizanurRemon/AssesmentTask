package com.technonext.assesmenttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.technonext.assesmenttask.navigations.AppNavigation
import com.technonext.designsystem.theme.AssessmentTaskTheme
import com.technonext.designsystem.theme.ThemeMode
import com.technonext.feed_presentation.settings.SettingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val settingsViewModel: MainActivityViewModel = hiltViewModel()

            val themeMode by settingsViewModel.themeMode.collectAsState(initial = ThemeMode.SYSTEM)

            //var themeMode by rememberSaveable { mutableStateOf(ThemeMode.SYSTEM) }

            AssessmentTaskTheme(themeMode = themeMode) {
                val navController: NavHostController = rememberNavController()
                AppNavigation(
                    navController = navController,
                    themeMode = themeMode
                )
            }
        }
    }
}