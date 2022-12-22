package com.dpulgarin.rickandmorty.ui.screens.characters
import com.dpulgarin.rickandmorty.data.models.Character

data class CharactersState(
    val loading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String? = ""
)
