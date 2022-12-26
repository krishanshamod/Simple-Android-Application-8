package com.krishanshamod.simple_android_application_8.data.main.repository

import com.krishanshamod.simple_android_application_8.data.main.api.MainService
import com.krishanshamod.simple_android_application_8.data.main.local.MainDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val  restAPI: MainService,
    private val  dao: MainDao
) {
}