package com.aryasurya.restaurantreview.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase


class FavoriteViewModel (restaurantUseCase: RestaurantUseCase) : ViewModel() {
    val favoriteRestaurant = restaurantUseCase.getFavoriteRestaurant().asLiveData()
}
