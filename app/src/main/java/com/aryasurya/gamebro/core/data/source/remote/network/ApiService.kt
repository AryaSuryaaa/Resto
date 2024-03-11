package com.aryasurya.gamebro.core.data.source.remote.network

import com.aryasurya.gamebro.core.data.source.remote.response.ListTourismResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("list")
    suspend fun getList(): ListTourismResponse
}