package com.aryasurya.restaurantreview.maps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aryasurya.restaurantreview.core.domain.usecase.RestaurantUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val restaurantUseCase: RestaurantUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(MapsViewModel::class.java) -> {
                MapsViewModel(restaurantUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}