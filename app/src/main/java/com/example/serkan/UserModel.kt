package com.example.serkan

import kotlinx.coroutines.coroutineScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserModel {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    suspend fun getUserDate(response: (UserResponse) -> Unit) {
        val request = getRetrofit().create(apiService::class.java).getDatosUser("users")
        coroutineScope {
            val body = request.body()
            body.let {

                if (request.isSuccessful) {
                    if (it != null) {
                        response(UserResponse.OnSuccess(it))
                    } else {
                        response(UserResponse.OnError("list is empty"))
                    }
                }
            } }
    }suspend fun getUserPost(response: (UserResponse) -> Unit) {
        val request = getRetrofit().create(apiService::class.java).getPostUser("posts")
        coroutineScope {
            val body = request.body()
            body.let {

                if (request.isSuccessful) {
                    if (it != null) {
                        response(UserResponse.OnSuccess(it))

                    } else {
                        response(UserResponse.OnError("ha ocurrido un error"))
                    }
                }
            } }
    }





}