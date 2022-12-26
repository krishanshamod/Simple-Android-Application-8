package com.krishanshamod.simple_android_application_8.data.main.api

import com.krishanshamod.simple_android_application_8.data.main.model.NetworkVideoContainer
import retrofit2.Response
import retrofit2.http.GET

interface MainService {

    @GET("devbytes")
    suspend fun getPlaylist(): Response<NetworkVideoContainer>

}