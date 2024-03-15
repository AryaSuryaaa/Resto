package com.dicoding.tourismapp.core.data.source.local

import com.dicoding.tourismapp.core.data.source.local.entity.RestaurantEntity
import com.dicoding.tourismapp.core.data.source.local.room.RestaurantDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
//class LocalDataSource @Inject constructor(private val tourismDao: TourismDao) {
//    fun getAllTourism(): Flow<List<TourismEntity>> = tourismDao.getAllTourism()
//
//    fun getFavoriteTourism(): Flow<List<TourismEntity>> = tourismDao.getFavoriteTourism()
//
//    suspend fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)
//
//    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
//        tourism.isFavorite = newState
//        tourismDao.updateFavoriteTourism(tourism)
//    }
//}

@Singleton
class LocalDataSource @Inject constructor(private val restaurantDao: RestaurantDao) {
    fun getAllRestaurant(): Flow<List<RestaurantEntity>> = restaurantDao.getAllRestaurant()

    fun getFavoriteRestaurant(): Flow<List<RestaurantEntity>> = restaurantDao.getFavoriteRestaurant()

    suspend fun insertRestaurant(restaurantList: List<RestaurantEntity>) = restaurantDao.insertRestaurant(restaurantList)

    fun setFavoriteTourism(restaurant: RestaurantEntity, newState: Boolean) {
        restaurant.isFavorite = newState
        restaurantDao.updateFavoriteRestaurant(restaurant)
    }
}