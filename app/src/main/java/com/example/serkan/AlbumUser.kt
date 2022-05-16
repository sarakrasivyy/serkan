package com.example.serkan

import com.google.gson.annotations.SerializedName

data class AlbumUser(

    @SerializedName("userId") var userIdAlbum: Int,
    @SerializedName("id") var idAlbumUser: Int,
    @SerializedName("title") var titleAlbumUser: String,

    )
