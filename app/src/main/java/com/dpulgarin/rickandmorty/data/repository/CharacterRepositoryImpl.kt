package com.dpulgarin.rickandmorty.data.repository

import com.dpulgarin.rickandmorty.data.local.LocalCharacterDataSource
import com.dpulgarin.rickandmorty.data.local.dao.CharacterDao
import com.dpulgarin.rickandmorty.data.remote.dto.location.CharacterLocationDTO
import com.dpulgarin.rickandmorty.data.remote.dto.characters.toCharacterEntity
import com.dpulgarin.rickandmorty.data.remote.RemoteCharacterDatasource
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val db: CharacterDao,
    private val dataSourceRemote: RemoteCharacterDatasource,
    private val dataSourceLocal: LocalCharacterDataSource
) : CharacterRepository {
    override suspend fun getCharacters(): List<CharacterResult> {
        return try {
            val favourites: List<Int> =
                db.loadFavoriteCharactersIds().firstOrNull().orEmpty().map { it.characterId }

            dataSourceRemote.getCharacters().characterDTOS.forEach { character ->
                dataSourceLocal.saveCharacter(
                    character.toCharacterEntity(
                        favourites.contains(
                            character.id
                        )
                    )
                )
            }
            dataSourceLocal.getCharacters()
        } catch (e: java.lang.Exception) {
            dataSourceLocal.getCharacters()
        }
    }

    override suspend fun getFavoritesCharacters(): Flow<List<CharacterResult>> {
        return db.loadFavoriteCharacters().map { w ->
            w.map {
                CharacterResult(
                    id = it.id,
                    name = it.name,
                    image = it.image,
                    location = it.locationDTO,
                    isFavourite = true,
                )
            }
        }
    }

    override suspend fun getCharacterLocation(locationId: Int): CharacterLocationDTO =
        dataSourceRemote.getCharacterLocation(locationId)

}
