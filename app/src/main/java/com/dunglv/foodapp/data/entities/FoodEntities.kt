package com.dunglv.foodapp.data.entities

data class FoodEntities(
    val `data`: Data,
    val message: String,
    val status: Boolean
)

data class Product(
    val calories: Int,
    val category: String,
    val created_at: Any,
    val description: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val price: Int,
    val size: String,
    val updated_at: Any
)

data class Data(
    val products: List<Product>
)