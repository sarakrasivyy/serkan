package com.example.serkan

sealed class RequesUser<out T> {
    object OnLoading : RequesUser<Nothing>()
    class OnSuccess<T>(val data: T) : RequesUser<T>()
    class OnError(val error: String) : RequesUser<Nothing>()
}