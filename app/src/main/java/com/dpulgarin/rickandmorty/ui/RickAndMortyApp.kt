package com.dpulgarin.rickandmorty.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dpulgarin.rickandmorty.ui.navigation.Navigation
import com.dpulgarin.rickandmorty.ui.screens.components.BottomBar
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.dpulgarin.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun RickAndMortyApp() {
    RickAndMortyScreen {
        Scaffold(
            bottomBar = {BottomBar()}
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
