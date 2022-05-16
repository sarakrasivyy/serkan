package com.example.serkan

sealed class UserResponse {
    class OnSuccess<T>(val data: T) : UserResponse()
    class OnError(val error: String) : UserResponse()
}