package com.krishanshamod.simple_android_application_8.api

import com.krishanshamod.simple_android_application_8.model.NetworkVideoContainer
import retrofit2.http.GET

interface DevbyteApiService {

    @GET("devbytes")
    suspend fun getPlaylist(): NetworkVideoContainer

}