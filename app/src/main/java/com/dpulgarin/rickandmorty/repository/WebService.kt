package com.dpulgarin.rickandmorty.repository

import com.dpulgarin.rickandmorty.data.models.CharacterList
import com.dpulgarin.rickandmorty.data.models.CharacterLocation
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("character")
    suspend fun getCharacters(): CharacterList

    @GET("location/{location_id}")
    suspend fun getCharacterLocation(@Path("location_id") locationId: Int): CharacterLocation
}
