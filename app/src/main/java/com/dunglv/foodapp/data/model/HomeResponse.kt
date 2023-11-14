package com.dunglv.foodapp.data.model

open class  HomeResponse (
    var status: Boolean,
    var message :String,
    var data: DataHome

)
open class DataHome(
    val products: List<DataProducts>
)
open class DataProducts(
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

