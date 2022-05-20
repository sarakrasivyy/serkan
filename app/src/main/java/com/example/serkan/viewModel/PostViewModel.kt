package com.example.serkan.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serkan.RequesUser
import com.example.serkan.UserResponse
import com.example.serkan.apiService.PostUser
import com.example.serkan.modelos.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PostViewModel: ViewModel() {
    private val postModel= UserModel()
    private val getPost: MutableLiveData<RequesUser<MutableList<PostUser>>> = MutableLiveData()
    private val getPostMutableLiveData: MutableLiveData<RequesUser<List<PostUser>>> = MutableLiveData()
    fun getPostvistaLiveData(): LiveData<RequesUser<List<PostUser>>> = getPostMutableLiveData


    fun getDatosPost() {
        getPostMutableLiveData.value = RequesUser.OnLoading
        viewModelScope.launch {
            postModel.getUserPost{ userResponse: UserResponse ->
                when (userResponse){
                    is UserResponse.OnSuccess<*> -> {
                        getPostMutableLiveData.postValue(
                            RequesUser.OnSuccess(userResponse.data as List<PostUser>)
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
}

private fun Any.launch(block: suspend CoroutineScope.() -> Unit) {


}
