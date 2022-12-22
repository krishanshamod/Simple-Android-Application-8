package com.krishanshamod.simple_android_application_8.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishanshamod.simple_android_application_8.api.RetrofitService
import com.krishanshamod.simple_android_application_8.model.DevbyteVideo
import com.krishanshamod.simple_android_application_8.model.NetworkVideoContainer
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel : ViewModel() {

    private val _playlist = MutableLiveData<List<DevbyteVideo>>()
    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    val playlist: LiveData<List<DevbyteVideo>>
        get() = _playlist

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        refreshData()
    }

    private fun refreshData() = viewModelScope.launch {
        try {
            val playlist = RetrofitService.devbytes.getPlaylist()
            _playlist.postValue(playlist.asDomainModel())

            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false

        } catch (error: IOException) {
            _eventNetworkError.value = true
            println("Error")
        }
    }
}