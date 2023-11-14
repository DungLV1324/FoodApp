package com.dunglv.foodapp.api

import com.dunglv.foodapp.data.model.LoginResponse
import com.dunglv.foodapp.data.model.SingUpResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface SingUpApi {

    @FormUrlEncoded
    @POST("/api/registration")
    fun singUp(
        @Field("username") username: String,
        @Field("phone_number") phonenumber: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<SingUpResponse>
}

