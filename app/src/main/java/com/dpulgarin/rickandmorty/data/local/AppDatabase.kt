package com.dpulgarin.rickandmorty.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dpulgarin.rickandmorty.application.AppConstants
import com.dpulgarin.rickandmorty.data.models.CharacterEntity

@Database(entities = [CharacterEntity::class], version = AppConstants.DATABASE_VERSION)
abstract class AppDatabase: RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "character_table"
            ).build()

            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}