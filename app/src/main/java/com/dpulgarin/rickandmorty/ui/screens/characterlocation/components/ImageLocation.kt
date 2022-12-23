package com.dpulgarin.rickandmorty.ui.screens.characterlocation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import coil.compose.AsyncImage
import com.dpulgarin.rickandmorty.R
import com.dpulgarin.rickandmorty.core.AppConstants

@Composable
fun ImageLocation(locationName: String) {
    val resourceImage: Int = if (locationName.contains(AppConstants.LOCATION_EARTH)) {
        R.drawable.location_earth
    } else if (locationName.contains(AppConstants.LOCATION_CITADEL)) {
        R.drawable.location_citadel
    } else {
        R.drawable.location_default
    }

    AsyncImage(
        model = resourceImage,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(percent = 10)),
    )
}
