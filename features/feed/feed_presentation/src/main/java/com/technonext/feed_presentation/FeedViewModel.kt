package com.technonext.feed_presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technonext.feed_domain.use_case.DeleteProductsUseCase
import com.technonext.feed_domain.use_case.GetProductsUseCase
import com.technonext.feed_domain.use_case.ObserveLocalDataUseCase
import com.technonext.network.utils.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val deleteProductsUseCase: DeleteProductsUseCase,
    private val getLocalDataUseCase: ObserveLocalDataUseCase
) : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 10
    }


    var state by mutableStateOf(FeedState())
        private set

    init {

        deleteProducts()
        loadLocalData()
    }

    private fun loadLocalData() {
        viewModelScope.launch {
            getLocalDataUseCase().collectLatest { products ->
                state = state.copy(productsList = products)

            }
        }
    }

    private fun deleteProducts() {
        viewModelScope.launch {
            deleteProductsUseCase()
        }
    }

    fun loadNextPage() {
        if (state.isLoading || state.endReached) return

        viewModelScope.launch {
            state = state.copy(isLoading = true)


            val skip = state.productsList.size
            when (val res = getProductsUseCase(limit = PAGE_SIZE, skip = skip)) {
                is ResultWrapper.Success -> {
                    val newItems = res.data
                    state = state.copy(
                        //productsList = state.productsList + newItems,
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

}