package com.dpulgarin.rickandmorty.ui.screens.detail
import com.dpulgarin.rickandmorty.data.models.CharacterLocation

data class CharacterDetailState(
    val loading: Boolean = false,
    val characterLocation: CharacterLocation? = null,
    val error: String? = ""
)
