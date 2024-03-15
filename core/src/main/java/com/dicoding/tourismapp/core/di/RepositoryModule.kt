package com.dicoding.tourismapp.core.di

import com.dicoding.tourismapp.core.data.RestaurantRepository
import com.dicoding.tourismapp.core.domain.repository.IRestaurantRepository
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