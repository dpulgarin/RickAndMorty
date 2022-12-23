package com.dpulgarin.rickandmorty.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavouriteCharacterEntity(
    @PrimaryKey val characterId: Int
)
