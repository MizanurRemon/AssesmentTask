package com.technonext.feed_domain.use_case

import com.technonext.feed_domain.model.ProductModel
import com.technonext.feed_domain.repository.FeedRepository
import com.technonext.network.model.CommonErrorModel
import com.technonext.network.utils.ResultWrapper

class GetProductsUseCase(private val feedRepository: FeedRepository) {
    suspend operator fun invoke(limit: Int, skip: Int): ResultWrapper<List<ProductModel>, CommonErrorModel>{
        return feedRepository.getProducts(limit, skip)
    }
}