package com.dpulgarin.rickandmorty.repository

import com.dpulgarin.rickandmorty.data.models.CharacterList
import retrofit2.http.GET

interface WebService {
    @GET("character")
    suspend fun getCharacters(): CharacterList
}
