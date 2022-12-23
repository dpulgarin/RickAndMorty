package com.dpulgarin.rickandmorty.data.remote.dto.location

import com.dpulgarin.rickandmorty.domain.vo.CharacterLocationResult

data class CharacterLocationDTO(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)

fun CharacterLocationDTO.toCharacterLocationResult(): CharacterLocationResult = CharacterLocationResult(
    this.created,
    this.dimension,
    this.name,
    this.residents,
    this.type
)
