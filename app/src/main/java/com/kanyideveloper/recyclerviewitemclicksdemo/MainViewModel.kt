package com.kanyideveloper.recyclerviewitemclicksdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val TAG = "MainViewModel"

    private val _reponse = MutableLiveData<List<Photo>>()
    val response: LiveData<List<Photo>>
        get() = _reponse

    init {
        getApiResponse()
    }

    private fun getApiResponse() {
        viewModelScope.launch {
            try {
                _reponse.value = PhotoApi.apiService.getPhotos()
            } catch (e: Exception) {
                Log.d(TAG, "getApiResponse: ${e.localizedMessage}")
            }
        }
    }
}