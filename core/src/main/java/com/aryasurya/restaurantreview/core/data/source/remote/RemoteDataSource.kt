package com.aryasurya.restaurantreview.core.data.source.remote

import android.util.Log
import com.aryasurya.restaurantreview.core.data.source.remote.network.ApiResponse
import com.aryasurya.restaurantreview.core.data.source.remote.network.ApiService
import com.aryasurya.restaurantreview.core.data.source.remote.response.RestaurantsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllRestaurant(): Flow<ApiResponse<List<RestaurantsItem>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getListRestaurant()
                val dataArray = response.restaurants
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.restaurants))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}