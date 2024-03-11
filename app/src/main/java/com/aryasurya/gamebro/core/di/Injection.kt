package com.aryasurya.gamebro.core.di

import android.content.Context

import com.aryasurya.gamebro.core.data.source.local.LocalDataSource
import com.aryasurya.gamebro.core.data.source.local.room.TourismDatabase

import com.aryasurya.gamebro.core.data.TourismRepository
import com.aryasurya.gamebro.core.data.source.remote.RemoteDataSource
import com.aryasurya.gamebro.core.utils.AppExecutors
import com.aryasurya.gamebro.core.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): TourismRepository {
        val database = TourismDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
