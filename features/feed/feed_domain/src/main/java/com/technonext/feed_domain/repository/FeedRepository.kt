package com.technonext.feed_domain.repository

import com.technonext.feed_domain.model.ProductModel
import com.technonext.network.model.CommonErrorModel
import com.technonext.network.utils.ResultWrapper
import kotlinx.coroutines.flow.Flow

interface FeedRepository {
    suspend fun getProducts(limit: Int, skip: Int): ResultWrapper<List<ProductModel>, CommonErrorModel>
    suspend fun deleteProducts()
    fun getLocalProducts(): Flow<List<ProductModel>>
    fun getFavoriteProducts(): Flow<List<ProductModel>>
    fun getFavoriteProductsCount(): Flow<Int>
    suspend fun updateFavorite(productId: Int, isFavorite: Boolean)
}