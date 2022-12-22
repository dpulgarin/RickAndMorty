package com.dpulgarin.rickandmorty.ui.screens.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dpulgarin.rickandmorty.data.models.Character

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel(),
    onCharacterClick: (Character) -> Unit
) {
    val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.characters) {
            CharacterItem(
                character = it,
                modifier = Modifier.clickable { onCharacterClick(it) }
            )
        }
    }

    if (state.loading) {
        CircularProgressIndicator()
    }
}

@Composable
fun CharacterItem(character: Character, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Card {
            Text(
                text = character.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}
