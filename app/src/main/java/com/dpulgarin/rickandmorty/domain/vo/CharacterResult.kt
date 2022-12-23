package com.dpulgarin.rickandmorty.domain.vo

import com.dpulgarin.rickandmorty.data.remote.dto.characters.LocationDTO

data class CharacterResult(
    val id: Int = -1,
    val name: String = "",
    val image: String = "",
    val location: LocationDTO,
)
