package com.example.serkan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel {
private val userModel = UserModel()
private val getUsers: MutableLiveData<RequesUser<MutableList<DatosUser>>> = MutableLiveData()
private val getUserMutableLiveData: MutableLiveData<RequesUser<List<String>>> = MutableLiveData()

fun getDogsLiveData(): LiveData<RequesUser<List<String>>> = getUserMutableLiveData
fun getRazasvista(): LiveData<RequesUser<MutableList<DatosUser>>> = getUsers


fun getImagesDogByRaza(query: String) {
    getUserMutableLiveData.value = RequesUser.OnLoading
    viewModelScope.launch {
        UserModel.getDogs(query){ dogResponse: UserResponse ->
            when (dogResponse){
                is UserResponse.OnSuccess<*> -> {
                    getUserMutableLiveData.postValue(
                        RequesUser.OnSuccess(dogResponse.data as List<String>)
                    )
                }
                is UserResponse.OnError -> {
                    getUserMutableLiveData.postValue(
                        RequesUser.OnError(dogResponse.error)
                    )

                }
            }
        }
    }
}
fun getRazasVi() {
    getDogRazasCom.value = RequestStatusDogs.OnLoading
    viewModelScope.launch {
        dogModel.getDogsitem{ dogResponse: DogResponse ->
            when (dogResponse){
                is DogResponse.OnSuccess<*> -> {

                    val data = dogResponse.data as Map<String, List<String>>
                    val razas = mutableListOf<Raza>()
                    data.keys.forEachIndexed { index, title ->
                        razas.add(Raza(id = index, title = title))
                    }
                    getDogRazasCom.postValue(
                        RequestStatusDogs.OnSuccess(razas)
                    )
                }
                is DogResponse.OnError -> {
                    getDogRazasCom.postValue(
                        RequestStatusDogs.OnError(dogResponse.error)
                    )

                }
            }
        }
    }
}
}