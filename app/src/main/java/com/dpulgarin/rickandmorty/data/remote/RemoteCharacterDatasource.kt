package com.dpulgarin.rickandmorty.data.remote

import com.dpulgarin.rickandmorty.data.models.CharacterList
import com.dpulgarin.rickandmorty.repository.WebService

class RemoteCharacterDatasource(private val webService: WebService) {
    suspend fun getCharacters(): CharacterList = webService.getCharacters()
}