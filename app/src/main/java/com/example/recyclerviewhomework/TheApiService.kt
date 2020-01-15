package com.example.recyclerviewhomework

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://content.guardianapis.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface TheApiService {
    @GET("search?q=12%20years%20a%20slave&format=json&tag=film/film,tone/reviews&from-date=2010-01-01&show-tags=contributor&show-fields=starRating,headline,thumbnail,short-url&order-by=relevance&api-key=da3e84a8-a10c-403d-9817-863e081ee713")
    fun getProperties(): Call<DownloadedData>
}

object TheApi {
    val retrofitService: TheApiService by lazy {
        retrofit.create(TheApiService::class.java)
    }
}
