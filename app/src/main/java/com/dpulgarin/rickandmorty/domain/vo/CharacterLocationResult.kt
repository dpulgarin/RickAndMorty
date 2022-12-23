package com.dpulgarin.rickandmorty.domain.vo

data class CharacterLocationResult(
    val created: String,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
)
