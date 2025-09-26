package com.technonext.feed_domain.di

import com.technonext.feed_domain.repository.FeedRepository
import com.technonext.feed_domain.use_case.DeleteProductsUseCase
import com.technonext.feed_domain.use_case.GetFavoriteProductsCountUseCase
import com.technonext.feed_domain.use_case.GetFavoritesProductsUseCase
import com.technonext.feed_domain.use_case.GetProductsUseCase
import com.technonext.feed_domain.use_case.ObserveLocalDataUseCase
import com.technonext.feed_domain.use_case.UpdateFavoriteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@InstallIn(ViewModelComponent::class)
@Module
class FeedDomainModule {
    @ViewModelScoped
    @Provides
    fun provideGetProductsUseCase(feedRepository: FeedRepository): GetProductsUseCase {
        return GetProductsUseCase(feedRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideDeleteProductsUseCase(feedRepository: FeedRepository): DeleteProductsUseCase {
        return DeleteProductsUseCase(feedRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideObserveLocalDataUseCase(feedRepository: FeedRepository): ObserveLocalDataUseCase {
        return ObserveLocalDataUseCase(feedRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideUpdateFavoriteUseCase(feedRepository: FeedRepository): UpdateFavoriteUseCase {
        return UpdateFavoriteUseCase(feedRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetFavoritesProductsUseCase(feedRepository: FeedRepository): GetFavoritesProductsUseCase {
        return GetFavoritesProductsUseCase(feedRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetFavoriteProductsCount(feedRepository: FeedRepository): GetFavoriteProductsCountUseCase {
        return GetFavoriteProductsCountUseCase(feedRepository)
    }
}