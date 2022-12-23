package com.dpulgarin.rickandmorty.data.local

import com.dpulgarin.rickandmorty.data.local.dao.CharacterDao
import com.dpulgarin.rickandmorty.data.local.db.CharacterEntity
import com.dpulgarin.rickandmorty.data.local.db.toCharacterList
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult
import javax.inject.Inject

class LocalCharacterDataSource @Inject constructor(
    private val characterDao: CharacterDao
) {
    suspend fun getCharacters(): List<CharacterResult> {
        return characterDao.getAllCharacters().toCharacterList()
    }

    suspend fun saveCharacter(character: CharacterEntity) {
        characterDao.saveCharacter(character)
    }
}
