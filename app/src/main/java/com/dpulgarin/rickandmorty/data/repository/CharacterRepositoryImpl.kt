package com.dpulgarin.rickandmorty.data.repository

import com.dpulgarin.rickandmorty.data.local.LocalCharacterDataSource
import com.dpulgarin.rickandmorty.data.remote.dto.location.CharacterLocationDTO
import com.dpulgarin.rickandmorty.data.remote.dto.characters.toCharacterEntity
import com.dpulgarin.rickandmorty.data.remote.RemoteCharacterDatasource
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSourceRemote: RemoteCharacterDatasource,
    private val dataSourceLocal: LocalCharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacters(): List<CharacterResult> {
        return try {
            dataSourceRemote.getCharacters().characterDTOS.forEach { character ->
                dataSourceLocal.saveCharacter(character.toCharacterEntity())
            }
            dataSourceLocal.getCharacters()
        } catch (e: java.lang.Exception) {
            dataSourceLocal.getCharacters()
        }
    }

    override suspend fun getCharacterLocation(locationId: Int): CharacterLocationDTO =
        dataSourceRemote.getCharacterLocation(locationId)

}
