package com.dpulgarin.rickandmorty.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    val navArgs: List<NavArg> = emptyList()
) {
    object Characters: NavItem("characters")
    object CharacterDetail: NavItem("characterdetail", listOf(NavArg.LocationId)) {
        fun createRoute(locationId: Int) = "$baseRoute/$locationId"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }
}

enum class NavArg(val key: String, val navType: NavType<*>) {
    LocationId("userId", NavType.IntType)
}
