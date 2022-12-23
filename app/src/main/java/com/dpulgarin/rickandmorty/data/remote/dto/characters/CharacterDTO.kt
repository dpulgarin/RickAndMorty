package com.dpulgarin.rickandmorty.data.remote.dto.characters

import com.dpulgarin.rickandmorty.data.local.db.CharacterEntity
import com.google.gson.annotations.SerializedName

data class CharacterDTO(
    val id: Int,
    val name: String,
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    @SerializedName("location")
    val locationDTO: LocationDTO,
    @SerializedName("origin")
    val originDTO: OriginDTO,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDTO.toCharacterEntity(): CharacterEntity = CharacterEntity(
    this.id,
    this.name,
    this.image,
    this.locationDTO
)
