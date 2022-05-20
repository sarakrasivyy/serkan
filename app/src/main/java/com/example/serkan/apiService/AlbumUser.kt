package com.example.serkan.apiService

import com.google.gson.annotations.SerializedName

data class AlbumUser(

    @SerializedName("userId") var userIdAlbum: Int,
    @SerializedName("id") var idAlbumUser: Int,
    @SerializedName("title") var titleAlbumUser: String,

    )
