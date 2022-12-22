package com.dpulgarin.rickandmorty.data.local

import com.dpulgarin.rickandmorty.data.models.Character
import com.dpulgarin.rickandmorty.data.models.CharacterEntity
import com.dpulgarin.rickandmorty.data.models.toCharacterList
import javax.inject.Inject

class LocalCharacterDataSource @Inject constructor(
    private val characterDao: CharacterDao
) {
    suspend fun getCharacters(): List<Character> {
        return characterDao.getAllCharacters().toCharacterList()
    }

    suspend fun saveCharacter(character: CharacterEntity) {
        characterDao.saveCharacter(character)
    }
}
