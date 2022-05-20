package com.example.serkan.apiService

import com.example.serkan.adaptadores.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface apiService {

    @GET
    suspend fun getDatosUser(@Url url: String): Response<List<User>>

    @GET
    suspend fun getPostUser(@Url url: String): Response<List<PostUser>>

    @GET
    suspend fun getAlbumUser(@Url url: String): Response<AlbumUser>

    @GET
    suspend fun getPhotosUser(@Url url: String): Response<PhotosUser>
}


