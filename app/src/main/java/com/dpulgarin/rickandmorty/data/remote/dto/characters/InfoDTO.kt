package com.dpulgarin.rickandmorty.data.remote.dto.characters

data class InfoDTO(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)
