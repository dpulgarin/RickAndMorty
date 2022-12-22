package com.dpulgarin.rickandmorty.repository

import com.dpulgarin.rickandmorty.data.local.LocalCharacterDataSource
import com.dpulgarin.rickandmorty.data.models.Character
import com.dpulgarin.rickandmorty.data.models.CharacterLocation
import com.dpulgarin.rickandmorty.data.models.toCharacterEntity
import com.dpulgarin.rickandmorty.data.remote.RemoteCharacterDatasource
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSourceRemote: RemoteCharacterDatasource,
    private val dataSourceLocal: LocalCharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return try {
            dataSourceRemote.getCharacters().characters.forEach { character ->
                dataSourceLocal.saveCharacter(character.toCharacterEntity())
            }
            dataSourceLocal.getCharacters()
        } catch (e: java.lang.Exception) {
            dataSourceLocal.getCharacters()
        }
    }

    override suspend fun getCharacterLocation(locationId: Int): CharacterLocation =
        dataSourceRemote.getCharacterLocation(locationId)

}
