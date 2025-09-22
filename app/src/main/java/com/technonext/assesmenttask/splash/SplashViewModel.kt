package com.technonext.assesmenttask.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technonext.common.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : ViewModel() {
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    init {
        viewModelScope.launch {
            delay(2000)

            _uiEvent.emit(UiEvent.Success)

            //_uiEvent.emit(UiEvent.NavigateUp)
        }
    }
}