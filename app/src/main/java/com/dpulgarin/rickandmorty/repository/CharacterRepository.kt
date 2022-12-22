package com.dpulgarin.rickandmorty.repository

import com.dpulgarin.rickandmorty.data.models.Character
import com.dpulgarin.rickandmorty.data.models.CharacterLocation

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
    suspend fun getCharacterLocation(locationId: Int): CharacterLocation
}