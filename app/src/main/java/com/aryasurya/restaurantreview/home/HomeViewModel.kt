package com.aryasurya.restaurantreview.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val restaurantUseCase: RestaurantUseCase) : ViewModel() {

    // Mendapatkan semua restoran
    val restaurant = restaurantUseCase.getAllRestaurant().asLiveData()

    // Fungsi untuk melakukan pencarian
    fun searchRestaurants(query: String) = restaurantUseCase.searchRestaurants(query).asLiveData()
}
