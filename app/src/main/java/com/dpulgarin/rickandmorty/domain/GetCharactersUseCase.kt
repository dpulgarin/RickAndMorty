package com.dpulgarin.rickandmorty.domain

import com.dpulgarin.rickandmorty.core.Resource
import com.dpulgarin.rickandmorty.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import com.dpulgarin.rickandmorty.data.models.Character

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<Resource<List<Character>>> = flow {
        try {
            emit(Resource.Loading())
            val results = repository.getCharacters().map {
                it
            }
            emit(Resource.Success(results))
        } catch (e: HttpException) {
            emit(Resource.Failure(e))
        } catch (e: IOException) {
            emit(Resource.Failure(e))
        }
    }
}
