package com.technonext.feed_domain.di

import com.technonext.feed_domain.repository.FeedRepository
import com.technonext.feed_domain.use_case.GetProductsUseCase
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
}