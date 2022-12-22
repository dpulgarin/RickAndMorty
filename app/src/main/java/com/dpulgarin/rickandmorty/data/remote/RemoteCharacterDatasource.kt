package com.dpulgarin.rickandmorty.data.remote

import com.dpulgarin.rickandmorty.data.models.CharacterList
import com.dpulgarin.rickandmorty.data.models.CharacterLocation
import com.dpulgarin.rickandmorty.repository.WebService
import javax.inject.Inject

class RemoteCharacterDatasource @Inject constructor(
    private val webService: WebService
) {
    suspend fun getCharacters(): CharacterList = webService.getCharacters()
    suspend fun getCharacterLocation(locationId: Int): CharacterLocation = webService.getCharacterLocation(locationId)
}
