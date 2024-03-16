package com.aryasurya.restaurantreview.core.data

import com.aryasurya.restaurantreview.core.data.source.local.LocalDataSource
import com.aryasurya.restaurantreview.core.data.source.remote.RemoteDataSource
import com.aryasurya.restaurantreview.core.data.source.remote.network.ApiResponse
import com.aryasurya.restaurantreview.core.data.source.remote.response.RestaurantsItem
import com.aryasurya.restaurantreview.core.domain.model.Restaurant
import com.aryasurya.restaurantreview.core.domain.repository.IRestaurantRepository
import com.aryasurya.restaurantreview.core.utils.AppExecutors
import com.aryasurya.restaurantreview.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestaurantRepository  @Inject constructor(
  private val remoteDataSource: RemoteDataSource,
  private val localDataSource: LocalDataSource,
  private val appExecutors: AppExecutors
) : IRestaurantRepository {
  override fun getAllRestaurant(): Flow<Resource<List<Restaurant>>> =
    object : NetworkBoundResource<List<Restaurant>, List<RestaurantsItem>>() {
      override fun loadFromDB(): Flow<List<Restaurant>> {
        return localDataSource.getAllRestaurant().map { DataMapper.mapEntitiesToDomain(it) }
      }

      override suspend fun createCall(): Flow<ApiResponse<List<RestaurantsItem>>> = remoteDataSource.getAllRestaurant()

      override suspend fun saveCallResult(data: List<RestaurantsItem>) {
        val restaurantList = DataMapper.mapResponsesToEntities(data)
        localDataSource.insertRestaurant(restaurantList)
      }

      override fun shouldFetch(data: List<Restaurant>?): Boolean = true

    }.asFlow()


  override fun getFavoriteRestaurant(): Flow<List<Restaurant>> {
    return localDataSource.getFavoriteRestaurant().map { DataMapper.mapEntitiesToDomain(it) }
  }

  override fun setFavoriteRestaurant(restaurant: Restaurant, state: Boolean) {
    val restaurantEntity = DataMapper.mapDomainToEntity(restaurant)
    appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(restaurantEntity, state) }
  }

  override fun searchRestaurants(searchQuery: String): Flow<List<Restaurant>> {
    return localDataSource.searchRestaurants(searchQuery).map { DataMapper.mapEntitiesToDomain(it) }
  }

}