package com.dpulgarin.rickandmorty.data.repository

import com.dpulgarin.rickandmorty.data.remote.dto.location.CharacterLocationDTO
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacters(): List<CharacterResult>
    suspend fun getFavoritesCharacters(): Flow<List<CharacterResult>>
    suspend fun getCharacterLocation(locationId: Int): CharacterLocationDTO
    suspend fun updateFavoriteCharacter(id: Int)
}
