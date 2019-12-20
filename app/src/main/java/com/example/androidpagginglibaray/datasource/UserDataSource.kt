package com.example.androidpagginglibaray.datasource

import androidx.paging.PageKeyedDataSource
import com.example.androidpagginglibaray.data.ApiService
import com.example.androidpagginglibaray.data.ApiServiceBuilder
import com.example.androidpagginglibaray.model.User
import com.example.androidpagginglibaray.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Ajeena on 13-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class UserDataSource : PageKeyedDataSource<Int, User>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, User>
    ) {
        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getUsers(FIRST_PAGE)
       /* call.enqueue(object : Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.users
                    responseItems?.let {
                        callback.onResult(responseItems, null, FIRST_PAGE + 1)
                    }
                }

            }

        })*/
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getUsers(params.key)
       /* call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.users
                    val key = params.key + 1
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }
        })*/

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val service = ApiServiceBuilder.buildService(ApiService::class.java)
        val call = service.getUsers(params.key)
       /* call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.users
                    val key = if (params.key > 1) params.key - 1 else 0
                    responseItems?.let {
                        callback.onResult(responseItems, key)
                    }
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }
        })*/
    }
    companion object{
        const val PAGE_SIZE = 6
        const val FIRST_PAGE = 1

    }
}