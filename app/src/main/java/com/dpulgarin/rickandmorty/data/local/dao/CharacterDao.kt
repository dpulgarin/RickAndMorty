package com.dpulgarin.rickandmorty.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.dpulgarin.rickandmorty.data.local.db.CharacterEntity
import com.dpulgarin.rickandmorty.data.local.db.FavouriteCharacterEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

@Dao
interface CharacterDao {
    @Query("SELECT * FROM CharacterEntity")
    suspend fun getAllCharacters(): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(characters: List<CharacterEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacter(character: CharacterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFavouritesCharacters(character: List<FavouriteCharacterEntity>)

    @Query("SELECT * FROM FavouriteCharacterEntity")
    fun loadFavouritesCharactersEntities(): Flow<List<FavouriteCharacterEntity>>

    @Transaction
    suspend fun updateFavoriteCharacter(id: Int) {
        val favouriteCharacterEntities = loadFavouritesCharactersEntities().firstOrNull()
        deleteFavouriteCharacterEntity()
        val favourites = if (favouriteCharacterEntities.orEmpty().contains(FavouriteCharacterEntity(id))) {
            favouriteCharacterEntities.orEmpty().filter { it.characterId != id }
        } else {
            favouriteCharacterEntities.orEmpty().plus(FavouriteCharacterEntity(id))
        }
        saveFavouritesCharacters(favourites)
        val characters: List<CharacterEntity> = getAllCharacters()
        deleteCharacters()
        saveCharacters(
            characters.map {
                if (it.id == id) {
                    it.copy(isFavourite = favourites.map { character -> character.characterId }.contains(it.id))
                } else {
                    it
                }
            }
        )
    }

    @Query("""SELECT * FROM CharacterEntity INNER JOIN FavouriteCharacterEntity ON id = characterId""")
    fun loadFavoriteCharacters(): Flow<List<CharacterEntity>>

    @Query("""SELECT * FROM FavouriteCharacterEntity """)
    fun loadFavoriteCharactersIds(): Flow<List<FavouriteCharacterEntity>>

    @Query("DELETE FROM CharacterEntity")
    fun deleteCharacters()

    @Query("DELETE FROM FavouriteCharacterEntity")
    fun deleteFavouriteCharacterEntity()
}
