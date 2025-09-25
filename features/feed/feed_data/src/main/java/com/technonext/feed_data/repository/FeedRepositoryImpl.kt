package com.technonext.feed_data.repository

import android.util.Log
import com.technonext.feed_data.dataSource.remote.FeedRemoteDataSource
import com.technonext.feed_data.mapper.toResponse
import com.technonext.feed_domain.model.ProductModel
import com.technonext.feed_domain.repository.FeedRepository
import com.technonext.network.model.CommonErrorModel
import com.technonext.network.utils.ExceptionalMessage
import com.technonext.network.utils.NetworkHandler
import com.technonext.network.utils.ResultWrapper
import com.technonext.network.utils.parseHttpException
import retrofit2.HttpException

class FeedRepositoryImpl(
    private val feedRemoteDataSource: FeedRemoteDataSource,
    private val networkHandler: NetworkHandler
) : FeedRepository {
    override suspend fun getProducts(limit: Int): ResultWrapper<List<ProductModel>, CommonErrorModel> {
        return if (networkHandler.isNetworkAvailable()) {
            try {

                val productsDto =
                    feedRemoteDataSource.getProducts(limit)

                val response = productsDto.products.map { it.toResponse() }

                return ResultWrapper.Success(response)
            } catch (e: HttpException) {
                val errorResponse = parseHttpException(e)
                ResultWrapper.Failure(errorResponse)

            } catch (e: Exception) {
                ResultWrapper.Failure(
                    CommonErrorModel(
                        message = e.message.toString(),
                    )
                )
            }
        } else {
            ResultWrapper.Failure(CommonErrorModel(message = ExceptionalMessage.INTERNET_NOT_AVAILABLE))
        }
    }
}