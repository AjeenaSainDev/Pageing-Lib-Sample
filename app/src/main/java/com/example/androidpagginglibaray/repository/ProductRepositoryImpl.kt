package com.example.androidpagginglibaray.repository

import com.example.androidpagginglibaray.datasource.RemoteData

/**
 * Created by Ajeena on 20-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class ProductRepositoryImpl(remoteData: RemoteData) : ProductRepository {
     var mremotedata = remoteData
    override fun getRemoteSource(): RemoteData {
        return  mremotedata
    }
}