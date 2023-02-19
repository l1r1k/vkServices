package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("semi-final-data.json")
    fun getServicesList(): Call<ServicesArray>
}