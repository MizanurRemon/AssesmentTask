package com.technonext.assesmenttask.navigations

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.technonext.assesmenttask.home.HomeScreen
import com.technonext.assesmenttask.home.HomeViewModel
import com.technonext.auth_presentation.login.LoginScreen
import com.technonext.auth_presentation.login.LoginViewModel
import com.technonext.auth_presentation.registration.SignUpScreen
import com.technonext.auth_presentation.registration.SignUpViewModel
import com.technonext.assesmenttask.splash.SplashScreen
import com.technonext.assesmenttask.splash.SplashViewModel
import com.technonext.auth_presentation.forgot_password.ForgotPasswordScreen
import com.technonext.auth_presentation.forgot_password.ForgotPasswordViewModel
import com.technonext.common.navigation.Route
import com.technonext.designsystem.theme.ThemeMode

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    themeMode: ThemeMode
) {
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        snackbarHost = { SnackbarHost(snackBarHostState) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Route.SPLASH,
            modifier = Modifier
                .padding(innerPadding)
                .windowInsetsPadding(WindowInsets.safeDrawing)
        ) {
            composable(Route.SPLASH) {
                val viewModel = hiltViewModel<SplashViewModel>()
                SplashScreen(
                    uiEvent = viewModel.uiEvent,
                    onLogin = {
                        navController.navigate(Route.LOGIN) {
                            popUpTo(navController.graph.id) {}
                        }
                    },
                    onHome = {
                        navController.navigate(Route.HOME) {
                            popUpTo(navController.graph.id) {}
                        }
                    }
                )
            }

            composable(route = Route.LOGIN) {
                val viewModel = hiltViewModel<LoginViewModel>()
                LoginScreen(
                    snackBarHostState = snackBarHostState,
                    onEvent = viewModel::onEvent,
                    state = viewModel.state,
                    uiEvent = viewModel.uiEvent,
                    onForgotPassword = {
                        navController.navigate(Route.FORGOT_PASSWORD)
                    },
                    onSignUp = {
                        navController.navigate(Route.SIGN_UP)
                    },
                    onHome = {
                        navController.navigate(Route.HOME) {
                            popUpTo(navController.graph.id) {}
                        }
                    }
                )
            }

            composable(route = Route.FORGOT_PASSWORD) {
                val viewModel = hiltViewModel<ForgotPasswordViewModel>()
                ForgotPasswordScreen(
                    onEvent = viewModel::onEvent,
                    state = viewModel.state,
                    onBack = {
                        navController.navigateUp()
                    }
                )
            }

            composable(route = Route.SIGN_UP) {
                val viewModel = hiltViewModel<SignUpViewModel>()
                SignUpScreen(
                    state = viewModel.state,
                    onEvent = viewModel::onEvent,
                    onSignIn = {
                        navController.navigateUp()
                    },
                    snackBarHostState = snackBarHostState,
                    uiEvent = viewModel.uiEvent,
                    onHome = {
                        navController.navigate(Route.HOME) {
                            popUpTo(navController.graph.id) {}
                        }
                    }
                )
            }

            composable(route = Route.HOME) {
                val viewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(
                    state = viewModel.state,
                    themeMode = themeMode
                )
            }
        }
    }

}