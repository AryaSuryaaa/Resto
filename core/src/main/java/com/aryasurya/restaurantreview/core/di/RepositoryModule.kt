package com.aryasurya.restaurantreview.core.di

import com.aryasurya.restaurantreview.core.data.RestaurantRepository
import com.aryasurya.restaurantreview.core.domain.repository.IRestaurantRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(restaurantRepository: RestaurantRepository): IRestaurantRepository

}