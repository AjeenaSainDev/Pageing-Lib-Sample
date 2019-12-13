package com.example.androidpagginglibaray.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ajeena on 13-12-2019.
 * Claysol MediaLabs Pvt Ltd
 * ajeena.sainudeen@claysol.com
 *
 */
class User
{
    @field:SerializedName("avatar")
    var avatar: String? = null
    @field:SerializedName("email")
    var email: String? = null
    @field:SerializedName("first_name")
    var firstName: String? = null
    @field:SerializedName("id")
    var id: Long? = null
    @field:SerializedName("last_name")
    var lastName: String? = null

}
class UserResponse {
    @field:SerializedName("data")
    var users: List<User>? = null
    @field:SerializedName("page")
    var page: Int = 0
    @field:SerializedName("per_page")
    var perPage: Long = 0
    @field:SerializedName("total")
    var total: Long = 0
    @field:SerializedName("total_pages")
    var totalPages: Int = 0
}