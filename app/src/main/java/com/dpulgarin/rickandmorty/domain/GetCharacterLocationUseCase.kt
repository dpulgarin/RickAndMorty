package com.dpulgarin.rickandmorty.domain

import com.dpulgarin.rickandmorty.core.Resource
import com.dpulgarin.rickandmorty.data.models.CharacterLocation
import com.dpulgarin.rickandmorty.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterLocationUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(locationId: Int): Flow<Resource<CharacterLocation>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getCharacterLocation(locationId)))
        } catch (e: HttpException) {
            emit(Resource.Failure(e))
        } catch (e: IOException) {
            emit(Resource.Failure(e))
        }
    }
}
