package com.technonext.feed_domain.repository

import com.technonext.feed_domain.model.ProductModel
import com.technonext.network.model.CommonErrorModel
import com.technonext.network.utils.ResultWrapper

interface FeedRepository {
    suspend fun getProducts(limit: Int): ResultWrapper<List<ProductModel>, CommonErrorModel>
}