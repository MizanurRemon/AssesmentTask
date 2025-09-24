package com.technonext.network

import com.technonext.network.dto.ProductsDto
import retrofit2.http.GET

interface PublicApiService {
    @GET("/products")
    suspend fun getProducts(): ProductsDto
}