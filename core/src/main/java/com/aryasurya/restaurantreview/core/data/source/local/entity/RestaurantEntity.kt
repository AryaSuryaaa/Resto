package com.aryasurya.restaurantreview.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "restaurant")
class RestaurantEntity (
  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "restaurantId")
  var restaurantId: String,

  @ColumnInfo(name = "name")
  var name: String,

  @ColumnInfo(name = "description")
  var description: String,

  @ColumnInfo(name = "city")
  var city: String,

  @ColumnInfo(name = "rating")
  var rating: String,

  @ColumnInfo(name = "pictureId")
  var pictureId: String,

  @ColumnInfo(name = "isFavorite")
  var isFavorite: Boolean = false

) : Parcelable