package com.dunglv.foodapp.data.model

open class SingUpResponse {
    var status: Boolean = false
    lateinit var message: String
    lateinit var data: DataSingUp
}
open class DataSingUp(
    var userName: String,
    var email: String)


