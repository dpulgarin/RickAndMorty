package com.dpulgarin.rickandmorty.repository

import com.dpulgarin.rickandmorty.data.models.Character

interface CharacterRepository {
    suspend fun getCharacters(ts: Long, hash: String): List<Character>
}