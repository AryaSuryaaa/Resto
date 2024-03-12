package com.aryasurya.gamebro.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aryasurya.gamebro.core.data.TourismRepository
import com.aryasurya.gamebro.core.domain.usecase.TourismUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {

    val tourism = tourismUseCase.getAllTourism().asLiveData()

}

