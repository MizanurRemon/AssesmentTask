package com.technonext.feed_data.dataSource.remote

import com.technonext.network.dto.ProductsDto

interface FeedRemoteDataSource {
    suspend fun getProducts( limit: Int): ProductsDto
}