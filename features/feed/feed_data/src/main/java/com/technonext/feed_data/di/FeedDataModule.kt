package com.technonext.feed_data.di

import com.technonext.common.util.CoroutineDispatcherProvider
import com.technonext.database.dao.ProductsDao
import com.technonext.feed_data.dataSource.local.FeedLocalDataSource
import com.technonext.feed_data.dataSource.remote.FeedRemoteDataSource
import com.technonext.feed_data.dataSourceImpl.local.FeedLocalDataSourceImpl
import com.technonext.feed_data.dataSourceImpl.remote.FeedRemoteDataSourceImpl
import com.technonext.feed_data.repository.FeedRepositoryImpl
import com.technonext.feed_domain.repository.FeedRepository
import com.technonext.network.PublicApiService
import com.technonext.network.di.TypeEnum
import com.technonext.network.di.qualifier.PublicNetwork
import com.technonext.network.utils.NetworkHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class FeedDataModule {
    @Singleton
    @Provides
    fun provideFeedRemoteDataSource(
        @PublicNetwork(TypeEnum.SERVICE) publicApiService: PublicApiService
    ): FeedRemoteDataSource {
        return FeedRemoteDataSourceImpl(publicApiService)
    }

    @Singleton
    @Provides
    fun providesFeedRepository(
        feedLocalDataSource: FeedLocalDataSource,
        feedRemoteDataSource: FeedRemoteDataSource,
        networkHandler: NetworkHandler
    ): FeedRepository {
        return FeedRepositoryImpl(
            feedRemoteDataSource = feedRemoteDataSource,
            networkHandler = networkHandler,
            feedLocalDataSource = feedLocalDataSource
        )
    }

    @Singleton
    @Provides
    fun provideFeedLocalDataSource(
        productsDao: ProductsDao,
        coroutineDispatcherProvider: CoroutineDispatcherProvider
    ): FeedLocalDataSource {
        return FeedLocalDataSourceImpl(
            productsDao = productsDao,
            coroutineDispatcherProvider = coroutineDispatcherProvider
        )
    }
}