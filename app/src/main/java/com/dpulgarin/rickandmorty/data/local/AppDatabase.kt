package com.dpulgarin.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dpulgarin.rickandmorty.application.AppConstants
import com.dpulgarin.rickandmorty.data.models.CharacterEntity

@Database(entities = [CharacterEntity::class], version = AppConstants.DATABASE_VERSION)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
