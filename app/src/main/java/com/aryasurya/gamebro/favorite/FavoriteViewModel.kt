package com.aryasurya.gamebro.favorite

import androidx.lifecycle.ViewModel
import com.aryasurya.gamebro.core.data.TourismRepository

class FavoriteViewModel(tourismRepository: TourismRepository) : ViewModel() {

    val favoriteTourism = tourismRepository.getFavoriteTourism()

}

