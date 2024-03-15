package com.dicoding.tourismapp.detail

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.R
import com.dicoding.tourismapp.core.domain.model.Restaurant
import com.dicoding.tourismapp.databinding.ActivityDetailRestaurantBinding

class DetailRestaurantActivity  : AppCompatActivity() {

  companion object {
    const val EXTRA_DATA = "extra_data"
  }

//    @Inject
//    lateinit var factory: ViewModelFactory

  private val detailRestaurantViewModel : DetailRestaurantViewModel by viewModels()
  private lateinit var binding: ActivityDetailRestaurantBinding

  override fun onCreate(savedInstanceState: Bundle?) {
//        (application as MyApplication).appComponent.inject(this)
    super.onCreate(savedInstanceState)
    binding = ActivityDetailRestaurantBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)

    val detailRestaurant = intent.getParcelableExtra<Restaurant>(EXTRA_DATA)
    showDetailRestaurant(detailRestaurant)
  }

  private fun showDetailRestaurant(detailRestaurant: Restaurant?) {
    detailRestaurant?.let {
      supportActionBar?.title = detailRestaurant.name
      binding.content.tvDetailDescription.text = detailRestaurant.description
      Glide.with(this@DetailRestaurantActivity)
        .load("https://restaurant-api.dicoding.dev/images/medium/"+detailRestaurant.pictureId)
        .into(binding.ivDetailImage)

      var statusFavorite = detailRestaurant.isFavorite
      setStatusFavorite(statusFavorite)
      binding.fab.setOnClickListener {
        statusFavorite = !statusFavorite
        detailRestaurantViewModel.setFavoriteRestaurant(detailRestaurant, statusFavorite)
        setStatusFavorite(statusFavorite)
        Log.d("TAGar", "showDetailRestaurant: $statusFavorite")
      }
    }
  }

  private fun setStatusFavorite(statusFavorite: Boolean) {
    if (statusFavorite) {
      binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
    } else {
      binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
    }
  }
}