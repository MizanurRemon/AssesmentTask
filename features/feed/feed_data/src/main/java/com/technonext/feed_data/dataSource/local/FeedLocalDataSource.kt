package com.technonext.feed_data.dataSource.local

import com.technonext.database.model.ProductEntity
import kotlinx.coroutines.flow.Flow

interface FeedLocalDataSource {
    suspend fun saveProducts(products: List<ProductEntity>)
    fun getProducts(searchKey: String): Flow<List<ProductEntity>>
    fun getFavoriteProducts(): Flow<List<ProductEntity>>
    fun getFavoriteProductsCount(): Flow<Int>
    suspend fun deleteUsers()
    //suspend fun resetPrimaryKey()
    suspend fun updateIsFavorite(id: Int, isFavorite: Boolean)
}