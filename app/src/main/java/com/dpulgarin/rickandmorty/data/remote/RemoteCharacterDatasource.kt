package com.dpulgarin.rickandmorty.data.remote

import com.dpulgarin.rickandmorty.data.remote.dto.characters.CharacterListDTO
import com.dpulgarin.rickandmorty.data.remote.dto.location.CharacterLocationDTO
import com.dpulgarin.rickandmorty.data.repository.WebService
import javax.inject.Inject

class RemoteCharacterDatasource @Inject constructor(
    private val webService: WebService
) {
    suspend fun getCharacters(): CharacterListDTO = webService.getCharacters()
    suspend fun getCharacterLocation(locationId: Int): CharacterLocationDTO =
        webService.getCharacterLocation(locationId)
}
