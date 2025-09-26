package com.technonext.network

import com.technonext.network.dto.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface PublicApiService {
    @GET("/products")
    suspend fun getProducts(@Query("limit") limit: Int, @Query("skip") skip: Int): ProductsDto
}