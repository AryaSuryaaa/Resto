package com.dicoding.tourismapp.core.data.source.remote.network

import com.dicoding.tourismapp.core.data.source.remote.response.ListRestaurantResponse
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getListRestaurant(): ListRestaurantResponse
}