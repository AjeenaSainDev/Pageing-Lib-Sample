package com.example.androidpagginglibaray.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.androidpagginglibaray.model.User


/**
 * Created by Ajeena on 13-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class DataSourceFactory : DataSource.Factory<Int, User>() {
    val userLiveDataSource = MutableLiveData<UserDataSource>()
    override fun create(): DataSource<Int, User> {
        val userDataSource = UserDataSource()
        userLiveDataSource.postValue(userDataSource)
        return userDataSource
    }

}