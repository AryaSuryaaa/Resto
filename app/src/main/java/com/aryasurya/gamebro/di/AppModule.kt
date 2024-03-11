package com.aryasurya.gamebro.di

import com.aryasurya.gamebro.core.domain.usecase.TourismInteractor
import com.aryasurya.gamebro.core.domain.usecase.TourismUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideTourismUseCase(tourismInteractor: TourismInteractor): TourismUseCase

}