package com.example.androidpagginglibaray

import android.app.Application
import com.example.androidpagginglibaray.di.AppComponent
import com.example.androidpagginglibaray.di.DaggerAppComponent
import com.example.androidpagginglibaray.di.module.ApiModule
import com.example.androidpagginglibaray.di.module.AppModule
import com.example.androidpagginglibaray.di.module.DataModule

/**
 * Created by Ajeena on 20-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class PagingApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    fun initDagger(pagingApp: PagingApp) : AppComponent =
        DaggerAppComponent.builder().appModule(AppModule(pagingApp)).
        apiModule(ApiModule()).dataModule(DataModule()).build()
}