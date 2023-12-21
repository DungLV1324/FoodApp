package com.dunglv.foodapp.data.model

open class  DetailFoodResponse (
    var status: Boolean,
    var message :String,
    var data: DataDetail
)
open class DataDetail(
    val product: Products
)
open class Products(
    var id: Int,
    var name: String,
    var description: String,
    var price: Int,
    var category: String,
    var calories: Int,
    var size: String,
    var image_url: String,
    var created_at: String?,
    var updated_at: String?)

