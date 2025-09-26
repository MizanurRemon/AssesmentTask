package com.technonext.feed_data.dataSourceImpl.local

import com.technonext.common.util.CoroutineDispatcherProvider
import com.technonext.database.dao.ProductsDao
import com.technonext.database.model.ProductEntity
import com.technonext.feed_data.dataSource.local.FeedLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class FeedLocalDataSourceImpl(
    private val productsDao: ProductsDao,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : FeedLocalDataSource {
    override suspend fun saveProducts(products: List<ProductEntity>) =
        withContext(coroutineDispatcherProvider.io) {
            productsDao.insertProducts(products)
        }

    override fun getProducts(): Flow<List<ProductEntity>> =
        productsDao.getProducts()

    override fun getFavoriteProducts(): Flow<List<ProductEntity>> =
        productsDao.getFavoriteProducts()

    override suspend fun deleteUsers() = withContext(coroutineDispatcherProvider.io) {
        productsDao.deleteUsers()
    }

    override suspend fun resetPrimaryKey() = withContext(coroutineDispatcherProvider.io) {
        productsDao.resetPrimaryKey()
    }


    override suspend fun updateIsFavorite(id: Int, isFavorite: Boolean) =
        withContext(coroutineDispatcherProvider.io) {
            productsDao.updateIsFavorite(id = id, isFavorite = isFavorite)
        }
}