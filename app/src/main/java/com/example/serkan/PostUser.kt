package com.example.serkan

import com.google.gson.annotations.SerializedName

data class PostUser(

    @SerializedName("userId") var userIdPost: Int,
    @SerializedName("id") var idPost: Int,
    @SerializedName("title") var titleUser: String,
    @SerializedName("body") var bodyUser: String,
)




