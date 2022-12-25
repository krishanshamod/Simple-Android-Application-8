package com.krishanshamod.simple_android_application_8.data.api

import com.krishanshamod.simple_android_application_8.data.model.NetworkVideoContainer
import retrofit2.http.GET

interface DevbyteApiService {

    @GET("devbytes")
    suspend fun getPlaylist(): NetworkVideoContainer

}