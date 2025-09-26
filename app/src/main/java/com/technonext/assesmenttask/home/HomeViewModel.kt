package com.technonext.assesmenttask.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technonext.feed_domain.use_case.GetFavoriteProductsCountUseCase
import com.technonext.feed_presentation.feed.FeedState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFavoriteProductsCountUseCase: GetFavoriteProductsCountUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set


    init {
        viewModelScope.launch(Dispatchers.IO) {
            getFavoriteProductsCountUseCase().collectLatest {
                state = state.copy(
                    favoriteCount = it
                )
            }

        }
    }

}