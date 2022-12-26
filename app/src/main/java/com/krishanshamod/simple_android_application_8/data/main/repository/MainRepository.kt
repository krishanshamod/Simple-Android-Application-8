package com.krishanshamod.simple_android_application_8.data.main.repository

import com.krishanshamod.simple_android_application_8.data.main.api.MainApiService
import com.krishanshamod.simple_android_application_8.data.main.local.MainDao
import com.krishanshamod.simple_android_application_8.data.performGetOperation
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val  restAPI: MainApiService,
    private val  dao: MainDao
) {
    fun findAll() = performGetOperation(
        databaseQuery = { dao.getVideos() },
        networkCall = { restAPI.findAll() },
        saveCallResult = { dao.insertAll(it.asDatabaseModel()) }
    )
}