package com.example.androidpagginglibaray.data

import androidx.lifecycle.Observer
import com.example.androidpagginglibaray.model.UserResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Ajeena on 13-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
interface ApiService {
    @GET("users")
    fun getUsers(@Query("page") page: Int): Observable<UserResponse>
    @GET("users")
    fun getUsersCall(@Query("page") page: Int): Call<UserResponse>

}