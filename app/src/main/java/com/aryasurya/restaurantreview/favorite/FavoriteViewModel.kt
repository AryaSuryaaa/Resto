package com.aryasurya.restaurantreview.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(restaurantUseCase: RestaurantUseCase) : ViewModel() {
    val favoriteRestaurant = restaurantUseCase.getFavoriteRestaurant().asLiveData()
}
