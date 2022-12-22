package com.dpulgarin.rickandmorty.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dpulgarin.rickandmorty.RickAndMortyApp
import com.dpulgarin.rickandmorty.data.models.Character
import com.dpulgarin.rickandmorty.data.models.Location
import com.dpulgarin.rickandmorty.data.models.Origin

@Composable
fun CharactersScreen(characters: List<Character>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(180.dp)) {
        items(characters) {
            CharacterItem(it)
        }
    }
}

@Composable
fun CharacterItem(character: Character) {
    Column(
        modifier = Modifier
    ) {
        Card {
            Text(
                text = character.name
            )
        }
    }
}

@Preview
@Composable
fun CharacterScreenPreview() {
    val characters = (1..10).map {
        Character(
            it,
            "Character $it",
            "",
            listOf(),
            "",
            "",
            Location("", ""),
            Origin("", ""),
            "",
            "",
            "",
            ""
        )
    }

    RickAndMortyApp {
        CharactersScreen(characters = characters)
    }
}