package com.technonext.assesmenttask.splash

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.technonext.common.util.UiEvent
import com.technonext.designsystem.theme.heading1TextStyle
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
                    onHome()
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
            .background(MaterialTheme.colorScheme.background),
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

        //Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(CommonR.string.app_name),
            style = heading1TextStyle
        )


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
fun PreviewSplashScreen() {
    SplashScreen(
        uiEvent = flow { },
        onLogin = {},
        onHome = {}
    )
}