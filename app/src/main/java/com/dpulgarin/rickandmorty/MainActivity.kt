package com.dpulgarin.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dpulgarin.rickandmorty.data.models.Character
import com.dpulgarin.rickandmorty.data.models.Location
import com.dpulgarin.rickandmorty.data.models.Origin
import com.dpulgarin.rickandmorty.ui.screens.CharactersScreen
import com.dpulgarin.rickandmorty.ui.theme.RickAndMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
    }
}

@Composable
fun RickAndMortyApp(content: @Composable () -> Unit) {
    RickAndMortyTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}
