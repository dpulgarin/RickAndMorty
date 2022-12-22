package com.dpulgarin.rickandmorty.repository

import com.dpulgarin.rickandmorty.core.InternetCheck
import com.dpulgarin.rickandmorty.data.local.LocalCharacterDataSource
import com.dpulgarin.rickandmorty.data.models.Character
import com.dpulgarin.rickandmorty.data.models.toCharacterEntity
import com.dpulgarin.rickandmorty.data.remote.RemoteCharacterDatasource
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSourceRemote: RemoteCharacterDatasource,
    private val dataSourceLocal: LocalCharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return if (InternetCheck.isNetworkAvailable()) {
            dataSourceRemote.getCharacters().characters.forEach { character ->
                dataSourceLocal.saveCharacter(character.toCharacterEntity())
            }
            return dataSourceLocal.getCharacters()
        } else {
            return dataSourceLocal.getCharacters()
        }
    }
}