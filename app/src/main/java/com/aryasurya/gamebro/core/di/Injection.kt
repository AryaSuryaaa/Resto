package com.aryasurya.gamebro.core.di

import android.content.Context

import com.aryasurya.gamebro.core.data.source.local.LocalDataSource
import com.aryasurya.gamebro.core.data.source.local.room.TourismDatabase

import com.aryasurya.gamebro.core.data.TourismRepository
import com.aryasurya.gamebro.core.data.source.remote.RemoteDataSource
import com.aryasurya.gamebro.core.domain.repository.ITourismRepository
import com.aryasurya.gamebro.core.domain.usecase.TourismInteractor
import com.aryasurya.gamebro.core.domain.usecase.TourismUseCase
import com.aryasurya.gamebro.core.utils.AppExecutors
import com.aryasurya.gamebro.core.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase {
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}
