package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
//class HomeViewModel @Inject constructor(tourismUseCase: TourismUseCase) : ViewModel() {
//
//    val tourism = tourismUseCase.getAllTourism().asLiveData()
//
//}

@HiltViewModel
class HomeViewModel @Inject constructor(restaurantUseCase: RestaurantUseCase) : ViewModel() {
    val restaurant = restaurantUseCase.getAllRestaurant().asLiveData()
}

