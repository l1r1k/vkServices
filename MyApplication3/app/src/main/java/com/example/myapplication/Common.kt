package com.example.myapplication

object Common {
    val apiInterface: ApiInterface
        get() = RequestBuilder().buildRequest().create(ApiInterface::class.java)
}