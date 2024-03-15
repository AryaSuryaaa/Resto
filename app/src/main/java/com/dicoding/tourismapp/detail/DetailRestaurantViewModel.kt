package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.dicoding.tourismapp.core.domain.model.Restaurant
import com.dicoding.tourismapp.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailRestaurantViewModel @Inject constructor(private val restaurantUseCase: RestaurantUseCase) : ViewModel() {
  fun setFavoriteRestaurant(restaurant: Restaurant, newStatus:Boolean) = restaurantUseCase.setFavoriteRestaurant(restaurant, newStatus)
}
