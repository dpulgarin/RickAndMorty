package com.dpulgarin.rickandmorty.data.repository

import com.dpulgarin.rickandmorty.data.remote.dto.location.CharacterLocationDTO
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterResult>
    suspend fun getCharacterLocation(locationId: Int): CharacterLocationDTO
}
