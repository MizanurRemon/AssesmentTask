package com.technonext.feed_presentation.feed

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technonext.feed_domain.use_case.DeleteProductsUseCase
import com.technonext.feed_domain.use_case.GetProductsUseCase
import com.technonext.feed_domain.use_case.ObserveLocalDataUseCase
import com.technonext.feed_domain.use_case.UpdateFavoriteUseCase
import com.technonext.network.utils.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val deleteProductsUseCase: DeleteProductsUseCase,
    private val getLocalDataUseCase: ObserveLocalDataUseCase,
    private val updateFavoriteUseCase: UpdateFavoriteUseCase
) : ViewModel() {

    companion object {
        private const val PAGE_SIZE = 10
    }

    var state by mutableStateOf(FeedState())
        private set

    private var localDataJob: Job? = null

    init {
        deleteProducts()
        // load all products initially
        loadLocalData("")
    }

    private fun deleteProducts() { viewModelScope.launch { deleteProductsUseCase() } }

    fun onEvent(event: FeedEvent) {
        when (event) {
            is FeedEvent.OnFavoriteClickEvent -> {
                viewModelScope.launch {
                    updateFavoriteUseCase(
                        productId = event.productId,
                        isFavorite = event.isFavorite
                    )
                }
            }

            is FeedEvent.OnSearchEvent -> {
                state = state.copy(
                    searchKey = event.searchKey,
                    // reset paging on new search
                    endReached = false
                )
                loadLocalData(event.searchKey)
            }
        }
    }

    private fun loadLocalData(searchKey: String) {
        localDataJob?.cancel()
        localDataJob = viewModelScope.launch {
            getLocalDataUseCase(searchKey).collectLatest { products ->
                state = state.copy(productsList = products)
            }
        }
    }

    fun refreshProducts() {
        viewModelScope.launch {
            deleteProductsUseCase()
            loadNextPage() // reload first page
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
                        isLoading = false,
                        endReached = newItems.size < PAGE_SIZE
                        // productsList comes automatically from local DB observer
                    )
                }

                is ResultWrapper.Failure -> {
                    state = state.copy(
                        isLoading = false,
                        error = "Failed to load products"
                    )
                }
            }
        }
    }
}
