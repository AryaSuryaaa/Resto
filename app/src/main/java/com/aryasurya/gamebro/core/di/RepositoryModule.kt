package com.aryasurya.gamebro.core.di

import com.aryasurya.gamebro.core.data.TourismRepository
import com.aryasurya.gamebro.core.domain.repository.ITourismRepository
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class, DatabaseModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(tourismRepository: TourismRepository): ITourismRepository

}