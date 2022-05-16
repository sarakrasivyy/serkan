package com.example.serkan

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface apiService {

    @GET
    suspend fun getDatosUser(@Url url: String): Response<DatosUser>

    @GET
    suspend fun getPostUser(@Url url: String): Response<PostUser>

    @GET
    suspend fun getAlbumUser(@Url url: String): Response<AlbumUser>

    @GET
    suspend fun getPhotosUser(@Url url: String): Response<PhotosUser>
}


