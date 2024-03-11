package com.aryasurya.gamebro

import android.app.Application
import com.aryasurya.gamebro.core.di.CoreComponent
import com.aryasurya.gamebro.core.di.DaggerCoreComponent
import com.aryasurya.gamebro.di.AppComponent
import com.aryasurya.gamebro.di.DaggerAppComponent

open class MyApplication : Application() {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(coreComponent)
    }
}