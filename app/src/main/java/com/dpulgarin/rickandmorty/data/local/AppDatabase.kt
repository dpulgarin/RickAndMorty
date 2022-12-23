package com.dpulgarin.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dpulgarin.rickandmorty.core.AppConstants
import com.dpulgarin.rickandmorty.data.local.dao.CharacterDao
import com.dpulgarin.rickandmorty.data.local.db.CharacterEntity
import com.dpulgarin.rickandmorty.data.local.db.FavouriteCharacterEntity

@Database(
    entities = [CharacterEntity::class, FavouriteCharacterEntity::class],
    version = AppConstants.DATABASE_VERSION
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
