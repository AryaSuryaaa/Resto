package com.aryasurya.gamebro.home

import androidx.lifecycle.ViewModel
import com.aryasurya.gamebro.core.data.TourismRepository

class HomeViewModel(tourismRepository: TourismRepository) : ViewModel() {

    val tourism = tourismRepository.getAllTourism()

}

