package com.dpulgarin.rickandmorty.data.remote.dto.characters

import com.google.gson.annotations.SerializedName

data class CharacterListDTO(
    @SerializedName("info")
    val infoDTO: InfoDTO,
    @SerializedName("results")
    val characterDTOS: List<CharacterDTO>
)
