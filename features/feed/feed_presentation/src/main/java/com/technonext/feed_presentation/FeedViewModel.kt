package com.technonext.feed_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technonext.feed_domain.use_case.GetProductsUseCase
import com.technonext.network.utils.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 20
    }


    var state by mutableStateOf(FeedState())
        private set

    /*init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
          val result =   getProductsUseCase(limit = 10)
            when(result){
                is ResultWrapper.Success -> {
                    state = state.copy(isLoading = false, productsList = result.data)
                    Log.d("dataxx", "${result.data}")
                }

                is ResultWrapper.Failure -> {
                    state = state.copy(isLoading = false)
                    Log.d("dataxx", "failed")
                }
            }
        }
    }*/
    init {
        loadNextPage()
    }

    fun loadNextPage() {
        if (state.isLoading || state.endReached) return

        viewModelScope.launch {
            state = state.copy(isLoading = true)

            // offset = current loaded count
            val offset = state.productsList.size
            when (val res = getProductsUseCase(limit = PAGE_SIZE)) {
                is ResultWrapper.Success -> {
                    val newItems = res.data
                    state = state.copy(
                        productsList = state.productsList + newItems,
                        isLoading = false,
                        endReached = newItems.size < PAGE_SIZE
                    )
                }

                is ResultWrapper.Failure -> {
                    state = state.copy(
                        isLoading = false,
                        error = "Failed to load"
                    )
                }
            }
        }
    }

    fun refresh() {
        if (state.isLoading) return
        state = FeedState()
        loadNextPage()
    }
}