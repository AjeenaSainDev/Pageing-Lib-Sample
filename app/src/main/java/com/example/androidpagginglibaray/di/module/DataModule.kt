package com.example.androidpagginglibaray.di.module

import com.example.androidpagginglibaray.data.ApiService
import com.example.androidpagginglibaray.datasource.RemoteData
import com.example.androidpagginglibaray.datasource.RemoteDataSource
import com.example.androidpagginglibaray.repository.ProductRepository
import com.example.androidpagginglibaray.repository.ProductRepositoryImpl
import javax.inject.Named
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Ajeena on 27-09-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 */
@Module
class DataModule {
    @Singleton
    @Provides
    fun provideFeedApiService(@Named("provideRetrofit") retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java!!)
    }

    @Singleton
    @Provides
    fun provideFeedRemoteService(feedAPIService: ApiService): RemoteData {
        return RemoteDataSource(feedAPIService)
    }

    @Singleton
    @Provides
    fun provideDataService(
        remoteDataSource: RemoteData

    ): ProductRepository {
        return ProductRepositoryImpl(remoteDataSource)
    }

}
