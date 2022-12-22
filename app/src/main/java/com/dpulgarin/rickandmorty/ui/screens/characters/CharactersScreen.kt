package com.dpulgarin.rickandmorty.ui.screens.characters

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dpulgarin.rickandmorty.data.models.Character

@Composable
fun CharactersScreen(viewModel: CharactersViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    LazyVerticalGrid(columns = GridCells.Adaptive(180.dp)) {
        items(state.characters) {
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
