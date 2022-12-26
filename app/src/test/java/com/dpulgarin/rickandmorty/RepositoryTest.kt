package com.dpulgarin.rickandmorty

import com.dpulgarin.rickandmorty.data.local.LocalCharacterDataSource
import com.dpulgarin.rickandmorty.data.local.dao.CharacterDao
import com.dpulgarin.rickandmorty.data.local.db.CharacterEntity
import com.dpulgarin.rickandmorty.data.remote.RemoteCharacterDatasource
import com.dpulgarin.rickandmorty.data.remote.dto.characters.LocationDTO
import com.dpulgarin.rickandmorty.data.repository.CharacterRepositoryImpl
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import junit.framework.Assert.assertSame
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RepositoryTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    lateinit var db: CharacterDao

    @MockK
    lateinit var localCharacterDataSource: LocalCharacterDataSource

    @MockK
    lateinit var remoteCharacterDataSource: RemoteCharacterDatasource

    private lateinit var repository: CharacterRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        repository =
            spyk(CharacterRepositoryImpl(db, remoteCharacterDataSource, localCharacterDataSource))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getFavoritesCharacters() = runTest {
        val expected = listOf(
            CharacterResult(
                id = 1,
                name = "Rick Sanchez",
                image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                location = LocationDTO("", ""),
                isFavourite = true
            )
        )

        coEvery { db.loadFavoriteCharacters() }.returns(
            flow {
                listOf(
                    CharacterResult(
                        id = 1,
                        name = "Rick Sanchez",
                        image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                        location = LocationDTO("", ""),
                        isFavourite = true
                    )
                )
            }
        )

        repository.getFavoritesCharacters().collect {
            assertSame(it, expected)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getCharacters() = runTest {
        val expected =
            listOf(
                CharacterResult(
                    id = 1,
                    name = "Rick Sanchez",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                    location = LocationDTO("", ""),
                    isFavourite = true
                )
            )


        coEvery {
            db.saveCharacter(
                CharacterEntity(
                    id = 1,
                    name = "Rick Sanchez",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                    locationDTO = LocationDTO("", ""),
                    isFavourite = true
                )

            )
        }.returns(
            Unit
        )

        coEvery { localCharacterDataSource.getCharacters() }.returns(
            listOf(
                CharacterResult(
                    id = 1,
                    name = "Rick Sanchez",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                    location = LocationDTO("", ""),
                    isFavourite = true
                )
            )
        )

        coEvery { db.getAllCharacters() }.returns(
            listOf(
                CharacterEntity(
                    id = 1,
                    name = "Rick Sanchez",
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                    locationDTO = LocationDTO("", ""),
                    isFavourite = true
                )
            )
        )

        assertSame(repository.getCharacters(), expected)
    }
}
