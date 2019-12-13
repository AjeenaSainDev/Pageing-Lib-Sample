package com.example.androidpagginglibaray.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.androidpagginglibaray.datasource.DataSourceFactory
import com.example.androidpagginglibaray.datasource.UserDataSource
import com.example.androidpagginglibaray.model.User

/**
 * Created by Ajeena on 13-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class UserViewModel :ViewModel() {
    var userPagedList: LiveData<PagedList<User>>
    private var liveDataSource: LiveData<UserDataSource>
    init {
        val datasourcefactory = DataSourceFactory()
        liveDataSource = datasourcefactory.userLiveDataSource
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(UserDataSource.PAGE_SIZE)
            .build()
        userPagedList = LivePagedListBuilder(datasourcefactory, config)
            .build()

    }

}