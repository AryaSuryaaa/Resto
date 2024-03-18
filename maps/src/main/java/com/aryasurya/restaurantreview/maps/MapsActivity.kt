package com.aryasurya.restaurantreview.maps

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aryasurya.restaurantreview.core.data.Resource
import com.aryasurya.restaurantreview.core.ui.RestaurantAdapter
import com.aryasurya.restaurantreview.detail.DetailRestaurantActivity
import com.aryasurya.restaurantreview.di.MapsModuleDependencies
import com.aryasurya.restaurantreview.maps.databinding.ActivityMapsBinding
import dagger.hilt.android.AndroidEntryPoint // Tambahkan anotasi @AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject


class MapsActivity : AppCompatActivity() {

  @Inject
  lateinit var factory: ViewModelFactory

  private val mapsViewModel: MapsViewModel by viewModels {
    factory
  }

  private lateinit var binding: ActivityMapsBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    DaggerMapsComponent.builder()
      .context(this)
      .appDependencies(
        EntryPointAccessors.fromApplication(
          applicationContext,
          MapsModuleDependencies::class.java
        )
      )
      .build()
      .inject(this)
    super.onCreate(savedInstanceState)
    binding = ActivityMapsBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.title = "Tourism Map"

    getTourismData()
  }

  private fun getTourismData() {
    mapsViewModel.restaurant.observe(this) { restaurant ->
      if (restaurant != null) {
        when (restaurant) {
          is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
          is Resource.Success -> {
            binding.progressBar.visibility = View.GONE
            binding.tvMaps.text = "This is map of ${restaurant.data?.get(0)?.name}"
          }
          is Resource.Error -> {
            binding.progressBar.visibility = View.GONE
            binding.tvError.visibility = View.VISIBLE
            binding.tvError.text = restaurant.message
          }
        }
      }
    }
  }

}
