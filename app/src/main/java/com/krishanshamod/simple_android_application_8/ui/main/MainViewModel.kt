package com.krishanshamod.simple_android_application_8.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krishanshamod.simple_android_application_8.data.main.api.MainService
import com.krishanshamod.simple_android_application_8.data.main.model.DevbyteVideo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainService: MainService) : ViewModel() {

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
            val playlist = mainService.getPlaylist()
            _playlist.postValue(playlist.asDomainModel())

            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false

        } catch (error: IOException) {
            _eventNetworkError.value = true
            println("Error")
        }
    }
}