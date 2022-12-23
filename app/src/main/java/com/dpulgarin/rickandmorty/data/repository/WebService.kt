package com.dpulgarin.rickandmorty.data.repository

import com.dpulgarin.rickandmorty.data.remote.dto.characters.CharacterListDTO
import com.dpulgarin.rickandmorty.data.remote.dto.location.CharacterLocationDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("character")
    suspend fun getCharacters(): CharacterListDTO

    @GET("location/{location_id}")
    suspend fun getCharacterLocation(@Path("location_id") locationId: Int): CharacterLocationDTO
}
