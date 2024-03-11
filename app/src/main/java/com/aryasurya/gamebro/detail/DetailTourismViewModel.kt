package com.aryasurya.gamebro.detail

import androidx.lifecycle.ViewModel
import com.aryasurya.gamebro.core.data.TourismRepository
import com.aryasurya.gamebro.core.data.source.local.entity.TourismEntity
import com.aryasurya.gamebro.core.domain.model.Tourism
import com.aryasurya.gamebro.core.domain.usecase.TourismUseCase

class DetailTourismViewModel(private val tourismUseCase: TourismUseCase) : ViewModel() {
    fun setFavoriteTourism(tourism: Tourism, newStatus:Boolean) = tourismUseCase.setFavoriteTourism(tourism, newStatus)
}

