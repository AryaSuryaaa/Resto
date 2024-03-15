package com.dicoding.tourismapp.core.domain.usecase

import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.data.RestaurantRepository
import com.dicoding.tourismapp.core.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestaurantInteractor @Inject constructor(private val restaurantRepository: RestaurantRepository): RestaurantUseCase {
  override fun getAllRestaurant() = restaurantRepository.getAllRestaurant()
  override fun getFavoriteRestaurant() = restaurantRepository.getFavoriteRestaurant()

  override fun setFavoriteRestaurant(restaurant: Restaurant, state: Boolean) = restaurantRepository.setFavoriteRestaurant(restaurant, state)
}
