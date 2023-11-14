package com.dunglv.foodapp.data.model

open class LoginResponse {
    var status: Boolean = false
    lateinit var message: String
    lateinit var data: Data
}
open class Data (var token: String)


