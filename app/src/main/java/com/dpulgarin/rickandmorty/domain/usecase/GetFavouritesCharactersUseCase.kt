package com.dpulgarin.rickandmorty.domain.usecase

import com.dpulgarin.rickandmorty.data.di.DispatchersProvider
import com.dpulgarin.rickandmorty.data.repository.CharacterRepository
import com.dpulgarin.rickandmorty.domain.vo.CharacterResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetFavouritesCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository,
    private val dispatcher: DispatchersProvider
) {
    operator fun invoke(): Flow<List<CharacterResult>> = flow {
        val results = repository.getFavoritesCharacters().flowOn(dispatcher.io)
    }
}
