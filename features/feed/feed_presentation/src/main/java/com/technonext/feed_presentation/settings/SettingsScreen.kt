package com.technonext.feed_presentation.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.technonext.designsystem.r
import com.technonext.designsystem.theme.ThemeMode
import com.technonext.designsystem.theme.bodyRegularTextStyle
import com.technonext.designsystem.theme.bodySmallTextStyle
import com.technonext.common.R as CommonR
import com.technonext.designsystem.R as DesignSystemR

@Composable
fun SettingsScreen(
    onEvent: (SettingsEvent) -> Unit,
    themeMode: ThemeMode
) {

    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            border = BorderStroke(1.r(), MaterialTheme.colorScheme.surfaceTint),
            shape = RoundedCornerShape(16.r()),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.r())
                .clickable {
                    showDialog = true
                },
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.r(), vertical = 15.r()),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = stringResource(CommonR.string.change_theme),
                    style = bodyRegularTextStyle
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    themeMode.name,
                    style = bodySmallTextStyle.copy(color = MaterialTheme.colorScheme.surfaceTint)
                )

                Spacer(modifier = Modifier.width(10.r()))

                Image(
                    painter = painterResource(DesignSystemR.drawable.ic_outline_arrow_forward),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.surfaceTint)
                )

            }
        }
    }

    if (showDialog) {
        ThemePickerDialog(
            currentTheme = themeMode,
            onDismiss = { showDialog = false },
            onThemeSelected = { selected ->
                onEvent(SettingsEvent.OnSavingTheme(selected))
                showDialog = false
            }
        )
    }
}

@Composable
fun ThemePickerDialog(
    currentTheme: ThemeMode,
    onDismiss: () -> Unit,
    onThemeSelected: (ThemeMode) -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Select Theme Mode") },
        text = {
            Column {
                ThemeRadioOption("System Default", ThemeMode.SYSTEM, currentTheme, onThemeSelected)
                ThemeRadioOption("Light", ThemeMode.LIGHT, currentTheme, onThemeSelected)
                ThemeRadioOption("Dark", ThemeMode.DARK, currentTheme, onThemeSelected)
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Composable
fun ThemeRadioOption(
    label: String,
    mode: ThemeMode,
    currentTheme: ThemeMode,
    onThemeSelected: (ThemeMode) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onThemeSelected(mode) }
            .padding(vertical = 8.dp)
    ) {
        RadioButton(
            selected = currentTheme == mode,
            onClick = { onThemeSelected(mode) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(label)
    }
}


@Composable
@Preview
fun PreviewSettingsScreen() {
    var themeMode by rememberSaveable { mutableStateOf(ThemeMode.SYSTEM) }
    SettingsScreen(themeMode = themeMode, onEvent = {})
}