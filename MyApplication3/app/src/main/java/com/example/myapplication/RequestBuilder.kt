package com.example.myapplication

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RequestBuilder {
    var url: String = "https://mobile-olympiad-trajectory.hb.bizmrg.com/"

    fun buildRequest(): Retrofit {
        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

        return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
    }
}