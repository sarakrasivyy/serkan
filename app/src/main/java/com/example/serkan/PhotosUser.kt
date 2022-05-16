package com.example.serkan

import com.google.gson.annotations.SerializedName

data class PhotosUser(

    @SerializedName("albumId") var albumIdPhotos: Int,
    @SerializedName("id") var idPhotos: Int,
    @SerializedName("title") var titlePhotos: String,
    @SerializedName("url") var urlPhotos: String,

    )
