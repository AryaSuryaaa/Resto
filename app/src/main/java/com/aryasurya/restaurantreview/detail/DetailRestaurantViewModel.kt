package com.aryasurya.restaurantreview.detail

import androidx.lifecycle.ViewModel
import com.aryasurya.restaurantreview.core.domain.model.Restaurant
import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailRestaurantViewModel @Inject constructor(private val restaurantUseCase: RestaurantUseCase) : ViewModel() {
  fun setFavoriteRestaurant(restaurant: Restaurant, newStatus:Boolean) = restaurantUseCase.setFavoriteRestaurant(restaurant, newStatus)
}
