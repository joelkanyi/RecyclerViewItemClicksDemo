package com.kanyideveloper.recyclerviewitemclicksdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _reponse = MutableLiveData<Memes>()
    val response: LiveData<Memes>
        get() = _reponse

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _failed = MutableLiveData<String>()
    val failed: LiveData<String>
        get() = _failed

    init {
        _loading.value = true
        getApiResponse()
    }

    private fun getApiResponse() {
        MemesApi.apiService.getPhotos().enqueue(object : Callback<Memes> {
            override fun onResponse(call: Call<Memes>, response: Response<Memes>) {
                _reponse.value = response.body()
                _loading.value = false
            }

            override fun onFailure(call: Call<Memes>, t: Throwable) {
                _loading.value = false
                _failed.value = t.localizedMessage
            }
        })
    }
}