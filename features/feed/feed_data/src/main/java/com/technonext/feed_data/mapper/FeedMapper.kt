package com.technonext.feed_data.mapper

import com.technonext.database.model.ProductEntity
import com.technonext.feed_domain.model.ProductModel
import com.technonext.network.dto.Products


fun Products.toResponse(): ProductModel {
    return ProductModel(
        id = id ?: 0,
        title = title ?: "",
        description = description ?: "",
        image = if (images.isNotEmpty()) images[0] else ""
    )
}

fun ProductModel.toEntity(): ProductEntity {
    return ProductEntity(
        productId = id,
        title = title,
        description = description,
        image = image
    )
}

fun ProductEntity.toResponse(): ProductModel {
    return ProductModel(
        id = productId,
        title = title,
        description = description,
        image = image,
        isFavorite = isFavorite
    )
}