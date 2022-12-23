package com.dpulgarin.rickandmorty.ui.screens.characterlocation
import com.dpulgarin.rickandmorty.domain.vo.CharacterLocationResult

data class CharacterLocationState(
    val loading: Boolean = false,
    val characterLocationResult: CharacterLocationResult? = null,
    val error: String? = ""
)
