package com.example.androidpagginglibaray.datasource

import androidx.lifecycle.Observer
import com.example.androidpagginglibaray.data.ApiService
import com.example.androidpagginglibaray.model.UserResponse
import io.reactivex.Observable
import retrofit2.Call

/**
 * Created by Ajeena on 20-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class RemoteDataSource(apiService: ApiService) : RemoteData {
    lateinit var apiService : ApiService
    override fun getUserDate(page: Int): Observable<UserResponse> {
        return apiService.getUsers(page)
    }
}