package com.aryasurya.gamebro.core.domain.repository

import androidx.lifecycle.LiveData
import com.aryasurya.gamebro.core.data.Resource
import com.aryasurya.gamebro.core.domain.model.Tourism

interface ITourismRepository {

    fun getAllTourism(): LiveData<Resource<List<Tourism>>>

    fun getFavoriteTourism(): LiveData<List<Tourism>>

    fun setFavoriteTourism(tourism: Tourism, state: Boolean)

}