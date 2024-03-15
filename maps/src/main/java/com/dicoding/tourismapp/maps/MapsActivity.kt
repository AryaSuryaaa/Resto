package com.dicoding.tourismapp.maps

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.maps.databinding.ActivityMapsBinding
import dagger.hilt.android.AndroidEntryPoint // Tambahkan anotasi @AndroidEntryPoint

@AndroidEntryPoint // Tambahkan anotasi @AndroidEntryPoint
class MapsActivity : AppCompatActivity() {

  private val mapsViewModel: MapsViewModel by viewModels()

  private lateinit var binding: ActivityMapsBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMapsBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.title = "Restaurant Map"

    getTourismData()
  }

  private fun getTourismData() {
//    mapsViewModel.tourism.observe(this) { tourism ->
//      if (tourism != null) {
//        when (tourism) {
//          is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
//          is Resource.Success -> {
//            binding.progressBar.visibility = View.GONE
//            binding.tvMaps.text = "This is map of ${tourism.data?.get(0)?.name}"
//          }
//          is Resource.Error -> {
//            binding.progressBar.visibility = View.GONE
//            binding.tvError.visibility = View.VISIBLE
//            binding.tvError.text = tourism.message
//          }
//        }
//      }
//    }
//  }
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
