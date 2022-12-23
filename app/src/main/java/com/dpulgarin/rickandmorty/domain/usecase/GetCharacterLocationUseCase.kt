package com.dpulgarin.rickandmorty.domain.usecase

import com.dpulgarin.rickandmorty.domain.vo.Resource
import com.dpulgarin.rickandmorty.data.remote.dto.location.toCharacterLocationResult
import com.dpulgarin.rickandmorty.data.repository.CharacterRepository
import com.dpulgarin.rickandmorty.domain.vo.CharacterLocationResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterLocationUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(locationId: Int): Flow<Resource<CharacterLocationResult>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getCharacterLocation(locationId).toCharacterLocationResult()))
        } catch (e: HttpException) {
            emit(Resource.Failure(e))
        } catch (e: IOException) {
            emit(Resource.Failure(e))
        }
    }
}
