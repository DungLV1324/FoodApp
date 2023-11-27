package com.dunglv.foodapp.api

import com.dunglv.foodapp.data.model.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface HomeApi {
    @GET("/api/product/get-all")
    fun getAllProducts(@Header("Authorization") token: String): Call<HomeResponse>

}

