package com.example.serkan.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serkan.adaptadores.User
import com.example.serkan.apiService.PostUser
import com.example.serkan.RequesUser
import com.example.serkan.modelos.UserModel
import com.example.serkan.UserResponse
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val userModel= UserModel()
    private val getUserss: MutableLiveData<RequesUser<MutableList<User>>> = MutableLiveData()git a
    fun getUservista(): LiveData<RequesUser<MutableList<User>>> = getUserss


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



