package com.example.serkan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.User
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val userModel= UserModel()
    private val getUserss: MutableLiveData<RequesUser<MutableList<User>>> = MutableLiveData()
    private val getUserMutableLiveData: MutableLiveData<RequesUser<List<String>>> = MutableLiveData()
    fun getUservista(): LiveData<RequesUser<MutableList<User>>> = getUserss

    fun getUserLiveData(): LiveData<RequesUser<List<String>>> = getUserMutableLiveData


    private val postModel= UserModel()
    private val getPost: MutableLiveData<RequesUser<MutableList<PostUser>>> = MutableLiveData()
    private val getPostMutableLiveData: MutableLiveData<RequesUser<List<String>>> = MutableLiveData()
    fun getPostvista(): LiveData<RequesUser<MutableList<PostUser>>> = getPost


    fun getDatosPost() {
        getPostMutableLiveData.value = RequesUser.OnLoading
        viewModelScope.launch {
            postModel.getUserPost{ userResponse: UserResponse ->
                when (userResponse){
                    is UserResponse.OnSuccess<*> -> {
                        getPostMutableLiveData.postValue(
                            RequesUser.OnSuccess(userResponse.data as List<String>)
                        )
                    }
                    is UserResponse.OnError -> {
                        getPostMutableLiveData.postValue(
                            RequesUser.OnError(userResponse.error)
                        )

                    }
                }
            }
        }
    }

    fun getDatosVista() {
        getUserss.value = RequesUser.OnLoading
        viewModelScope.launch {
            userModel.getUserDate{ userResponse: UserResponse ->
                when (userResponse){
                    is UserResponse.OnSuccess<*> -> {

                        val data = userResponse.data as MutableList<User>
                        getUserss.postValue(
                            RequesUser.OnSuccess(data)
                        )
                    }
                    is UserResponse.OnError -> {
                        getUserss.postValue(
                            RequesUser.OnError(userResponse.error)
                        )

                    }
                }
            }
        }
    }
}



