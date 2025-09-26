package com.technonext.feed_presentation.favorite

import com.technonext.feed_domain.model.ProductModel

data class FavoriteState (
    val productsList: List<ProductModel> = emptyList()
)