package com.technonext.feed_data.dataSourceImpl.remote

import com.technonext.feed_data.dataSource.remote.FeedRemoteDataSource
import com.technonext.network.PublicApiService
import com.technonext.network.dto.ProductsDto

class FeedRemoteDataSourceImpl(val publicApiService: PublicApiService) :
    FeedRemoteDataSource {
    override suspend fun getProducts(limit: Int): ProductsDto {
        return publicApiService.getProducts(limit)
    }
}