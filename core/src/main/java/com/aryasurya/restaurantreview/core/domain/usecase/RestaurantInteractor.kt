package com.aryasurya.restaurantreview.core.domain.usecase

import com.aryasurya.restaurantreview.core.data.RestaurantRepository
import com.aryasurya.restaurantreview.core.domain.model.Restaurant
import javax.inject.Inject

class RestaurantInteractor @Inject constructor(private val restaurantRepository: RestaurantRepository): RestaurantUseCase {
  override fun getAllRestaurant() = restaurantRepository.getAllRestaurant()
  override fun getFavoriteRestaurant() = restaurantRepository.getFavoriteRestaurant()

  override fun setFavoriteRestaurant(restaurant: Restaurant, state: Boolean) = restaurantRepository.setFavoriteRestaurant(restaurant, state)

  override fun searchRestaurants(searchQuery: String)= restaurantRepository.searchRestaurants(searchQuery)

}
