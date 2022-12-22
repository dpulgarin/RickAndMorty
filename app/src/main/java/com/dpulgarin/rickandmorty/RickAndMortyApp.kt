package com.dpulgarin.rickandmorty

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dpulgarin.rickandmorty.ui.navigation.Navigation
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.dpulgarin.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun RickAndMortyApp() {
    RickAndMortyScreen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Rick y Morty")
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ) { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation()
            }
        }

        SetStatusBarColorEffect()
    }
}

@Composable
fun RickAndMortyScreen(content: @Composable () -> Unit) {
    RickAndMortyTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun SetStatusBarColorEffect(
    color: Color = MaterialTheme.colors.primaryVariant,
    systemUiController: SystemUiController = rememberSystemUiController()
) {
    SideEffect {
        systemUiController.setStatusBarColor(color)
    }
}
