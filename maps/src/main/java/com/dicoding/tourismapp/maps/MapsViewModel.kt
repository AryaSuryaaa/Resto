package com.dicoding.tourismapp.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.tourismapp.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel // Tambahkan anotasi @HiltViewModel
import javax.inject.Inject

@HiltViewModel // Tambahkan anotasi @HiltViewModel
class MapsViewModel @Inject constructor(restaurantUseCase: RestaurantUseCase) : ViewModel() {
  val restaurant = restaurantUseCase.getAllRestaurant().asLiveData()
}