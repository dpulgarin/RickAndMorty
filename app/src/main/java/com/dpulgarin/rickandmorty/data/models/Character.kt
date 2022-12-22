package com.dpulgarin.rickandmorty.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Character(
    val id: Int,
    val name: String,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val location: Location,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

// Room
@Entity
data class CharacterEntity (
    @PrimaryKey
    val id: Int = -1,
    @ColumnInfo(name="name")
    val name: String = "",
)

fun List<CharacterEntity>.toCharacterList(): List<Character> {
    val resultList = mutableListOf<Character>()

    this.forEach{ characterEntity ->
        resultList.add(characterEntity.toCharacter())
    }

    return resultList
}

fun CharacterEntity.toCharacter(): Character = Character(
    this.id,
    this.name,
    "",
    listOf(),
    "",
    "",
    Location("", ""),
    Origin("", ""),
    "",
    "",
    "",
    ""
)

fun Character.toCharacterEntity(): CharacterEntity = CharacterEntity(
    this.id,
    this.name
)
