package com.dpulgarin.rickandmorty.ui.screens.characters
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult

data class CharactersState(
    val loading: Boolean = false,
    val characterResult: List<CharacterResult> = emptyList(),
    val error: String? = ""
)
