package com.example.randomfox.network

import com.example.randomfox.models.FoxModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://randomfox.ca/"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FoxApiService {
    @GET("floof")
    suspend fun getRandomFox() : FoxModel
}

object FoxApi {
    val retrofitService : FoxApiService by lazy {
        retrofit.create(FoxApiService::class.java)
    }
}