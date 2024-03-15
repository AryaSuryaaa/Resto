package com.dicoding.tourismapp.core.utils

import com.dicoding.tourismapp.core.data.source.local.entity.RestaurantEntity
import com.dicoding.tourismapp.core.data.source.remote.response.RestaurantsItem
import com.dicoding.tourismapp.core.domain.model.Restaurant

object DataMapper {
//    fun mapResponsesToEntities(input: List<TourismResponse>): List<TourismEntity> {
//        val tourismList = ArrayList<TourismEntity>()
//        input.map {
//            val tourism = TourismEntity(
//                tourismId = it.id,
//                description = it.description,
//                name = it.name,
//                address = it.address,
//                latitude = it.latitude,
//                longitude = it.longitude,
//                like = it.like,
//                image = it.image,
//                isFavorite = false
//            )
//            tourismList.add(tourism)
//        }
//        return tourismList
//    }
//
//    fun mapEntitiesToDomain(input: List<TourismEntity>): List<Tourism> =
//        input.map {
//            Tourism(
//                tourismId = it.tourismId,
//                description = it.description,
//                name = it.name,
//                address = it.address,
//                latitude = it.latitude,
//                longitude = it.longitude,
//                like = it.like,
//                image = it.image,
//                isFavorite = it.isFavorite
//            )
//        }
//
//    fun mapDomainToEntity(input: Tourism) = TourismEntity(
//        tourismId = input.tourismId,
//        description = input.description,
//        name = input.name,
//        address = input.address,
//        latitude = input.latitude,
//        longitude = input.longitude,
//        like = input.like,
//        image = input.image,
//        isFavorite = input.isFavorite
//    )

    fun mapResponsesToEntities(input: List<RestaurantsItem>): List<RestaurantEntity> {
        val restaurantList = ArrayList<RestaurantEntity>()
        input.map {
            val restaurant = RestaurantEntity(
                restaurantId = it.id,
                description = it.description,
                name = it.name,
                city = it.city,
                pictureId = it.pictureId,
                rating = it.rating,
                isFavorite = false
            )
            restaurantList.add(restaurant)
        }
        return restaurantList
    }

    fun mapEntitiesToDomain(input: List<RestaurantEntity>): List<Restaurant> =
        input.map {
            Restaurant(
                restaurantId = it.restaurantId,
                description = it.description,
                name = it.name,
                pictureId = it.pictureId,
                rating = it.rating,
                city = it.city,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Restaurant) = RestaurantEntity(
        restaurantId = input.restaurantId,
        description = input.description,
        name = input.name,
        city = input.city,
        rating = input.rating,
        pictureId = input.pictureId,
        isFavorite = input.isFavorite
    )
}