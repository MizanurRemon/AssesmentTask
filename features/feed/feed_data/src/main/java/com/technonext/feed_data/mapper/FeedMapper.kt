package com.technonext.feed_data.mapper

import com.technonext.feed_domain.model.ProductModel
import com.technonext.network.dto.Products


fun Products.toResponse(): ProductModel {
    return ProductModel(
        id = id ?: 0,
        title = title ?: "",
        description = description ?: "",
        category = category ?: "",
        price = price ?: 0.0,
        discountPercentage = discountPercentage ?: 0.0,
        rating = rating ?: 0.0,
        images = images

    )
}