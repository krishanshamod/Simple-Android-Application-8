package com.krishanshamod.simple_android_application_8.data.main.api

import com.krishanshamod.simple_android_application_8.data.BaseDataSource
import javax.inject.Inject

class MainApiService @Inject constructor(
    private val  mainService: MainService
) : BaseDataSource() {

    suspend fun findAll() = getResult { mainService.getPlaylist() }

}