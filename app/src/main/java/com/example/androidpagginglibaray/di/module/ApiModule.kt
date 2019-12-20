package com.example.androidpagginglibaray.di.module

import android.content.Context
import com.example.androidpagginglibaray.utils.Constant
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Ajeena on 20-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class ApiModule {
    companion object {
        private const val NAME_BASE_URL = "NAME_BASE_URL"
    }
    @Provides
    @Named(NAME_BASE_URL)
    fun provideBaseUrlString() = "${Constant.BASE_URL}"

    @Provides
    @Singleton
    internal fun provideOkHttpCache(application: Context): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val requestBuilder = originalRequest.newBuilder()
                val response = chain.proceed(requestBuilder.build())
                // Throw specific Exception on HTTP 204 response code
                response
            }
            /**for logging api request and response */
            .addNetworkInterceptor(interceptor)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    @Named("provideRetrofit")
    internal fun provideRetrofit(okHttpClient: OkHttpClient , @Named(NAME_BASE_URL) base_url : String): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(base_url)
            .client(okHttpClient)
            .build()
    }

}