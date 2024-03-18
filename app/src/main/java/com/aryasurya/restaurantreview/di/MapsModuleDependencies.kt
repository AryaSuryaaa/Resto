package com.aryasurya.restaurantreview.di

import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface MapsModuleDependencies {
    fun restaurantUseCase(): RestaurantUseCase
}