package com.dpulgarin.rickandmorty.ui.screens.characters.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dpulgarin.rickandmorty.R
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult
import com.dpulgarin.rickandmorty.ui.screens.common.ImageFromUrl

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    characterResult: CharacterResult,
    onFavouriteClick: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
            .width(150.dp)
    ) {
        Card(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        ) {
            ImageFromUrl(
                url = characterResult.image,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
        Text(
            text = characterResult.name,
            modifier = Modifier.padding(top = 4.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = characterResult.location.name,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Icon(
            painter = painterResource(id = if (characterResult.isFavourite) {
                R.drawable.ic_baseline_favorite_24
            } else {
                R.drawable.ic_baseline_favorite_border_24
            }),
            contentDescription = null,
            modifier = modifier
                .size(24.dp)
                .clickable {
                    onFavouriteClick(characterResult.id)
                },
            tint = Color.Unspecified
        )
    }
}
