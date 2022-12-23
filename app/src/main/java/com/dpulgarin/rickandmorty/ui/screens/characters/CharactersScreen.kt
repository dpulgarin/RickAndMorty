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
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel(),
    onCharacterClick: (Int) -> Unit
) {
    val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(state.characterDTOS) {
            CharacterItem(
                characterResult = it,
                modifier = Modifier.clickable {
                    onCharacterClick(
                        viewModel.getLocationIdFromUri(it.location.url.toUri())
                    )
                }
            )
        }
    }

    if (state.loading) {
        CircularProgressIndicator()
    }
}

@Composable
fun CharacterItem(characterResult: CharacterResult, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Card {
            Text(
                text = characterResult.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}
