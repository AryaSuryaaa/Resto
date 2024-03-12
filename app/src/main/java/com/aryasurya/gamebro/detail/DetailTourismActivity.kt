package com.aryasurya.gamebro.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.aryasurya.gamebro.MyApplication
import com.bumptech.glide.Glide
import com.aryasurya.gamebro.R
import com.aryasurya.gamebro.core.data.source.local.entity.TourismEntity
import com.aryasurya.gamebro.core.domain.model.Tourism
import com.aryasurya.gamebro.databinding.ActivityDetailTourismBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailTourismActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

//    @Inject
//    lateinit var factory: ViewModelFactory

    private val detailTourismViewModel: DetailTourismViewModel by viewModels()
    private lateinit var binding: ActivityDetailTourismBinding

    override fun onCreate(savedInstanceState: Bundle?) {
//        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailTourism = intent.getParcelableExtra<Tourism>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun showDetailTourism(detailTourism: Tourism?) {
        detailTourism?.let {
            supportActionBar?.title = detailTourism.name
            binding.content.tvDetailDescription.text = detailTourism.description
            Glide.with(this@DetailTourismActivity)
                .load(detailTourism.image)
                .into(binding.ivDetailImage)

            var statusFavorite = detailTourism.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteTourism(detailTourism, statusFavorite)
                setStatusFavorite(statusFavorite)
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
