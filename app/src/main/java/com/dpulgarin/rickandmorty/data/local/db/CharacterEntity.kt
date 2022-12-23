package com.dpulgarin.rickandmorty.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dpulgarin.rickandmorty.data.remote.dto.characters.LocationDTO
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Int = -1,
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "image")
    val image: String = "",
    @Embedded(prefix = "location") val locationDTO: LocationDTO,
    @ColumnInfo(name = "favourite")
    val isFavourite: Boolean,
)

fun CharacterEntity.toCharacterResult(): CharacterResult = CharacterResult(
    this.id,
    this.name,
    this.image,
    this.locationDTO
)

fun List<CharacterEntity>.toCharacterList(): List<CharacterResult> {
    val resultList = mutableListOf<CharacterResult>()

    this.forEach { characterEntity ->
        resultList.add(characterEntity.toCharacterResult())
    }

    return resultList
}
