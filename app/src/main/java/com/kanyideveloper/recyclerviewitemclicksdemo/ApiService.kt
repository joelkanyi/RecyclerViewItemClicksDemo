package com.kanyideveloper.recyclerviewitemclicksdemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("")
    fun getPhotos(): List<Photo>
}

object PhotoApi {
    private const val BASE_URL = ""
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val apiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}