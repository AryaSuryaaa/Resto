package com.aryasurya.restaurantreview.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant (
  val restaurantId: String,
  val name: String,
  val description: String,
  val city: String,
  val rating: String,
  val pictureId: String,
  val isFavorite: Boolean
) : Parcelable