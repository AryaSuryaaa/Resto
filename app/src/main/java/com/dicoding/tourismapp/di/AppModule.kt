package com.dicoding.tourismapp.di

import com.dicoding.tourismapp.core.domain.usecase.RestaurantInteractor
import com.dicoding.tourismapp.core.domain.usecase.RestaurantUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideRestaurantUseCase(restaurantInteractor: RestaurantInteractor): RestaurantUseCase
//    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase

}