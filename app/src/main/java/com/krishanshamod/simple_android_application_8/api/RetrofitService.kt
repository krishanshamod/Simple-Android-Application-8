package com.krishanshamod.simple_android_application_8.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val devbytes = retrofit.create(DevbyteApiService::class.java)
}