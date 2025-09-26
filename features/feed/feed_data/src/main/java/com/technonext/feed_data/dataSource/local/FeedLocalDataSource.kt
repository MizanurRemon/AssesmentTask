package com.technonext.feed_data.dataSource.local

import com.technonext.database.model.ProductEntity
import kotlinx.coroutines.flow.Flow

interface FeedLocalDataSource {
    suspend fun saveProducts(products: List<ProductEntity>)
    fun getProducts(): Flow<List<ProductEntity>>
    suspend fun deleteUsers()
    suspend fun resetPrimaryKey()
    suspend fun updateIsFavorite(id: Int, isFavorite: Boolean)
}