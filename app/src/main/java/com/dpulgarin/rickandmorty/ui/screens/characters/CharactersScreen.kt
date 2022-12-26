package com.dpulgarin.rickandmorty.ui.screens.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import com.dpulgarin.rickandmorty.R
import com.dpulgarin.rickandmorty.ui.screens.characters.components.CharacterItem
import com.dpulgarin.rickandmorty.ui.screens.characters.components.RickAndMortyHeader

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel(),
    onCharacterClick: (Int) -> Unit
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        RickAndMortyHeader()

        Text(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
            text = stringResource(R.string.characters),
            color = colorResource(id = R.color.blue_primary),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        if (state.characterResult.isNotEmpty()) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                state = rememberLazyListState()
            ) {
                items(state.characterResult) {
                    CharacterItem(
                        characterResult = it,
                        modifier = Modifier.clickable {
                            onCharacterClick(
                                viewModel.getLocationIdFromUri(it.location.url.toUri())
                            )
                        },
                        onFavouriteClick = { id ->
                            viewModel.setFavouriteId(id)
                        }
                    )
                }
            }
        }
    }

    if (state.loading) {
        CircularProgressIndicator()
    }
}
