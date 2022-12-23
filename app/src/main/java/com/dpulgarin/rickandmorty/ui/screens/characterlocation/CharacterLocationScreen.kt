package com.dpulgarin.rickandmorty.ui.screens.characterlocation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dpulgarin.rickandmorty.R
import com.dpulgarin.rickandmorty.ui.screens.characterlocation.components.ImageLocation

@Composable
fun CharacterLocationScreen(
    viewModel: CharacterLocationViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    if (state.loading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

    state.characterLocationResult?.let { locationResult ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp),
                text = stringResource(R.string.location),
                color = colorResource(id = R.color.blue_primary),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )

            ImageLocation(locationName = locationResult.name.lowercase())

            Text(
                text = locationResult.name,
                modifier = Modifier.padding(top = 8.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = locationResult.type,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
