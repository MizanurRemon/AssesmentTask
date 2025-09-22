package com.technonext.assesmenttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.technonext.assesmenttask.navigations.AppNavigation
import com.technonext.designsystem.theme.AssessmentTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AssessmentTaskTheme {
                val navController: NavHostController = rememberNavController()
                AppNavigation(
                    navController = navController
                )
            }
        }
    }
}