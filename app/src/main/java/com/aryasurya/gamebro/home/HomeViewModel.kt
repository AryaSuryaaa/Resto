package com.aryasurya.gamebro.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aryasurya.gamebro.core.data.TourismRepository
import com.aryasurya.gamebro.core.domain.usecase.TourismUseCase

class HomeViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()

}

