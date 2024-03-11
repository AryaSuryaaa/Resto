package com.aryasurya.gamebro.core.domain.repository

import androidx.lifecycle.LiveData
import com.aryasurya.gamebro.core.data.Resource
import com.aryasurya.gamebro.core.domain.model.Tourism
import kotlinx.coroutines.flow.Flow

interface ITourismRepository {

    fun getAllTourism(): Flow<Resource<List<Tourism>>>

    fun getFavoriteTourism(): Flow<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}