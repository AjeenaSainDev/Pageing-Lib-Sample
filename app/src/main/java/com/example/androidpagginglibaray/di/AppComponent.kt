package com.example.androidpagginglibaray.di

import com.example.androidpagginglibaray.MainActivity
import com.example.androidpagginglibaray.datasource.UserDataSource
import com.example.androidpagginglibaray.di.module.ApiModule
import com.example.androidpagginglibaray.di.module.AppModule
import com.example.androidpagginglibaray.di.module.DataModule
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Ajeena on 20-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
@Singleton
@Component(modules =[AppModule::class, ApiModule::class, DataModule::class] )
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject (userDataSource: UserDataSource)

}