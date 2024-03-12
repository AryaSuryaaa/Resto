package com.aryasurya.gamebro.di

import com.aryasurya.gamebro.core.di.CoreComponent
import com.aryasurya.gamebro.detail.DetailTourismActivity
import com.aryasurya.gamebro.favorite.FavoriteFragment
import com.aryasurya.gamebro.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}