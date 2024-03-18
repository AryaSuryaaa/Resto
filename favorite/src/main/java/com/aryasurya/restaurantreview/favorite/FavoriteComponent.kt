package com.aryasurya.restaurantreview.favorite

import android.content.Context
import com.aryasurya.restaurantreview.di.FavoriteModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

  fun inject(activity: FavoriteFragment)

  @Component.Builder
  interface Builder {
    fun context(@BindsInstance context: Context): Builder
    fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
    fun build(): FavoriteComponent
  }

}