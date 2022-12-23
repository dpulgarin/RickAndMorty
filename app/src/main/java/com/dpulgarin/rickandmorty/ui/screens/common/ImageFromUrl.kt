package com.dpulgarin.rickandmorty.ui.screens.common

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
fun ImageFromUrl(
    url: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    BoxWithConstraints(modifier = modifier, contentAlignment = Alignment.Center) {
        AsyncImage(
            model = url,
            modifier = modifier.fillMaxSize(),
            contentScale = contentScale,
            contentDescription = "",
        )
    }
}
