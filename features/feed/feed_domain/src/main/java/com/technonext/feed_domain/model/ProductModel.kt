package com.technonext.feed_domain.model

data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    var images: List<String> = emptyList()
)
