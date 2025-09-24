package com.technonext.assesmenttask.home.bottom_nav_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.technonext.designsystem.theme.bodyBoldTextStyle
import com.technonext.common.R as CommonR
import com.technonext.designsystem.R as DesignSystemR

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(DesignSystemR.drawable.ic_settings),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stringResource(CommonR.string.settings), style = bodyBoldTextStyle)

    }
}


@Composable
@Preview
fun PreviewSettingsScreen() {
    SettingsScreen()
}