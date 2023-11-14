package com.dunglv.foodapp.api

import com.dunglv.foodapp.data.model.DetailFoodResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface DetailApi {
    @GET("/api/product/get/{id}")

    fun getDetail(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
    ): Call<DetailFoodResponse>

}

