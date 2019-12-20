package com.example.androidpagginglibaray.datasource

import com.example.androidpagginglibaray.model.User
import com.example.androidpagginglibaray.model.UserResponse
import io.reactivex.Observable
import io.reactivex.Observer
import retrofit2.Call

/**
 * Created by Ajeena on 20-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
interface RemoteData {
    fun getUserDate (page : Int): Observable<UserResponse>
}