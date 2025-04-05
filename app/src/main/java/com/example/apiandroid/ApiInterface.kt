package com.example.apiandroid

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("products")
    fun getProducts(): Call<Mydata>

}