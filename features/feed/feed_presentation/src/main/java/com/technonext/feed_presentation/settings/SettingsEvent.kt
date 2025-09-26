package com.technonext.feed_presentation.settings

import com.technonext.designsystem.theme.ThemeMode

sealed class SettingsEvent {
    data class OnSavingTheme(val theme: ThemeMode): SettingsEvent()
}