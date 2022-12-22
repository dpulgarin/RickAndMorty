package com.dpulgarin.rickandmorty.repository

import com.dpulgarin.rickandmorty.data.local.LocalCharacterDataSource
import com.dpulgarin.rickandmorty.data.models.Character
import com.dpulgarin.rickandmorty.data.models.toCharacterEntity
import com.dpulgarin.rickandmorty.data.remote.RemoteCharacterDatasource

class CharacterRepositoryImpl(
    private val dataSourceRemote: RemoteCharacterDatasource,
    private val dataSourceLocal: LocalCharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        dataSourceRemote.getCharacters().characters.forEach { character ->
            dataSourceLocal.saveCharacter(character.toCharacterEntity())
        }
        return dataSourceLocal.getCharacters()
    }
}