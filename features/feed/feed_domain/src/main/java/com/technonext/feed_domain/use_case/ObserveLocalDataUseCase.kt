package com.technonext.feed_domain.use_case

import com.technonext.feed_domain.model.ProductModel
import com.technonext.feed_domain.repository.FeedRepository
import kotlinx.coroutines.flow.Flow

class ObserveLocalDataUseCase(private val feedRepository: FeedRepository) {
    operator fun invoke(searchKey: String): Flow<List<ProductModel>> {
        return feedRepository.getLocalProducts(searchKey)
    }
}