package com.example.serkan.modelos

import com.example.serkan.UserResponse
import com.example.serkan.apiService.apiService
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
            val body = request
            body.let {

                if (request.isSuccessful) {
                    if (it != null) {
                        response(UserResponse.OnSuccess(it.body()))
                    } else {
                        response(UserResponse.OnError("list is empty"))
                    }
                }
            }
        }
    }

    suspend fun getUserPost(query: String, response: (UserResponse) -> Unit) {
        val request1 = getRetrofit().create(apiService::class.java).getPostUser("posts?userId=$query")
        coroutineScope {
            val body = request1.body()
            body.let {

                if (request1.isSuccessful) {
                    if (it != null) {
                        response(UserResponse.OnSuccess(it))

                    } else {
                        response(UserResponse.OnError("ha ocurrido un error"))
                    }
                }
            }
        }
    }
}