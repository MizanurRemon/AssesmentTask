package com.technonext.feed_presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technonext.datastore.PreferenceDataStoreConstants
import com.technonext.datastore.PreferenceDataStoreHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferenceDataStoreHelper: PreferenceDataStoreHelper
) : ViewModel() {

    init {

    }

    fun onEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.OnSavingTheme -> {
                viewModelScope.launch {
                    preferenceDataStoreHelper.savePreference(PreferenceDataStoreConstants.THEME, event.theme.name)
                }
            }
        }
    }
}