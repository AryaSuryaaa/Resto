package com.aryasurya.restaurantreview.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel // Tambahkan anotasi @HiltViewModel
import javax.inject.Inject

@HiltViewModel // Tambahkan anotasi @HiltViewModel
class MapsViewModel @Inject constructor(restaurantUseCase: RestaurantUseCase) : ViewModel() {
  val restaurant = restaurantUseCase.getAllRestaurant().asLiveData()
}