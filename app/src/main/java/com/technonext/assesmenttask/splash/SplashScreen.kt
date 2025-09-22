package com.technonext.assesmenttask.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.technonext.common.util.UiEvent
import com.technonext.designsystem.theme.BACKGROUND_COLOR
import com.technonext.designsystem.theme.bodyMediumTextStyle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.technonext.common.R as CommonR

@Composable
fun SplashScreen(
    uiEvent: Flow<UiEvent>,
    onLogin: () -> Unit,
    onHome: () -> Unit
) {

    LaunchedEffect(key1 = true) {
        uiEvent.collect { event ->

            when (event) {
                is UiEvent.Success -> {
                    onLogin()
                }

                is UiEvent.ShowSnackbar -> {
                }

                is UiEvent.NavigateUp -> {
                    onLogin()
                }
            }

        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BACKGROUND_COLOR),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

       /* Image(
            painter = painterResource(
                DesignSystemR.drawable.ic_logo
            ),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )*/

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(CommonR.string.app_name),
            style = bodyMediumTextStyle
        )


    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen(
        uiEvent = flow { },
        onLogin = {},
        onHome = {}
    )
}