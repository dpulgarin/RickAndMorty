package com.dpulgarin.rickandmorty.ui.screens.characters.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dpulgarin.rickandmorty.R

@Composable
fun RickAndMortyHeader() {
    Box(
        modifier = Modifier
            .height(350.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = R.drawable.rick_and_morty_subheader,
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(percent = 10)),
        )
        AsyncImage(
            model = R.drawable.rick_and_morty_header,
            modifier = Modifier
                .height(180.dp)
                .align(Alignment.TopCenter),
            contentDescription = null
        )
    }
}
