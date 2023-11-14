package com.dunglv.foodapp.api

import com.dunglv.foodapp.data.model.HomeResponse
import com.dunglv.foodapp.data.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query


interface HomeApi {
    @GET("/api/product/get-all")
    fun getAllProducts(@Header("Authorization") token: String): Call<HomeResponse>

}

