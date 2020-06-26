package com.ransoft.androidcoroutines.simplifiedcoading.data.network

import com.ransoft.androidcoroutines.simplifiedcoading.data.network.responses.QuotesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {
//    @GET("quotes")
//    fun getQuotes() : Call<QuotesResponse>

    @GET("quotes")
    suspend fun getQuotes(): Response<QuotesResponse>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .build()
                .create(MyApi::class.java)
        }
    }
}