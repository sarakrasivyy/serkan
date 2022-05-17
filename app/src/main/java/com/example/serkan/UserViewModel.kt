package com.example.serkan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val userModel= UserModel()
    private val getUserss: MutableLiveData<RequesUser<MutableList<DatosUser>>> = MutableLiveData()
    private val getUserMutableLiveData: MutableLiveData<RequesUser<List<String>>> = MutableLiveData()

    fun getDogsLiveData(): LiveData<RequesUser<List<String>>> = getUserMutableLiveData
    fun getRazasvista(): LiveData<RequesUser<MutableList<DatosUser>>> = getUserss


    fun getDatosUser(query: String) {
        getUserMutableLiveData.value = RequesUser.OnLoading
        viewModelScope.launch {
            userModel.getUserDate(){ userResponse: UserResponse ->
                when (userResponse){
                    is UserResponse.OnSuccess<*> -> {
                        getUserMutableLiveData.postValue(
                            RequesUser.OnSuccess(userResponse.data as List<String>)
                        )
                    }
                    is UserResponse.OnError -> {
                        getUserMutableLiveData.postValue(
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

                        val data = userResponse.data as MutableList<String>
                        val datos = mutableListOf<DatosUser>()
                        data.forEachIndexed { index, title ->
                            datos.add(DatosUser(idUser = index, nameUser = title, emailUser= title, phoneUser=title))
                        }
                        getUserss.postValue(
                            RequesUser.OnSuccess(datos)
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



