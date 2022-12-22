package com.dpulgarin.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dpulgarin.rickandmorty.data.models.CharacterEntity

@Dao
interface CharacterDao {
    @Query("SELECT * FROM characterentity")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacter(character: CharacterEntity)
}