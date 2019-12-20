package com.example.androidpagginglibaray.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Ajeena on 20-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
@Module
class AppModule (private val app: Application) {
    @Provides
    @Singleton
    fun provideContext(): Context = app
}