package com.dpulgarin.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dpulgarin.rickandmorty.ui.screens.characters.CharactersScreen
import com.dpulgarin.rickandmorty.ui.screens.detail.CharacterDetailScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavItem.Characters.route) {
        composable(NavItem.Characters) {
            CharactersScreen(
                onCharacterClick = { idLocation ->
                    navController.navigate(NavItem.CharacterDetail.createRoute(idLocation))
                }
            )
        }
        composable(NavItem.CharacterDetail) {
            CharacterDetailScreen()
        }
    }
}

fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navItem.route,
        arguments = navItem.args
    ) {
        content(it)
    }
}
