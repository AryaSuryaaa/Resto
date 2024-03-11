package com.aryasurya.gamebro.detail

import androidx.lifecycle.ViewModel
import com.aryasurya.gamebro.core.data.TourismRepository
import com.aryasurya.gamebro.core.data.source.local.entity.TourismEntity
import com.aryasurya.gamebro.core.domain.model.Tourism

class DetailTourismViewModel(private val tourismRepository: TourismRepository) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismRepository.setFavoriteTourism(tourism, newStatus)
}

