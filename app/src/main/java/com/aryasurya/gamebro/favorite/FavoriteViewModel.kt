package com.aryasurya.gamebro.favorite

import androidx.lifecycle.ViewModel
import com.aryasurya.gamebro.core.data.TourismRepository
import com.aryasurya.gamebro.core.domain.usecase.TourismUseCase

class FavoriteViewModel(tourismUseCase: TourismUseCase) : ViewModel() {

    val favoriteTourism = tourismUseCase.getFavoriteTourism()

}

