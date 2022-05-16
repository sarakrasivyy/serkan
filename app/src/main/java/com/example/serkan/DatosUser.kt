package com.example.serkan

import com.google.gson.annotations.SerializedName

data class DatosUser(

    @SerializedName("id") var idUser: Int,
    @SerializedName("name") var nameUser: String,
    @SerializedName("email") var emailUser: String,
    @SerializedName("phone") var phoneUser: String,
)
