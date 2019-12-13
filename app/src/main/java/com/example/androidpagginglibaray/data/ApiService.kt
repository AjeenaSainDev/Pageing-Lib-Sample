package com.example.androidpagginglibaray.data

import com.example.androidpagginglibaray.model.UserResponse
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
    fun getUsers(@Query("page") page: Int): Call<UserResponse>

}