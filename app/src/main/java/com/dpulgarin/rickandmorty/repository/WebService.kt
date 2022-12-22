package com.dpulgarin.rickandmorty.repository

import com.dpulgarin.rickandmorty.application.AppConstants
import com.dpulgarin.rickandmorty.data.models.CharacterList
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("character")
    suspend fun getCharacters(): CharacterList

    object RetrofitClient {
        val webService by lazy {
            Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(WebService::class.java)
        }

    }
}