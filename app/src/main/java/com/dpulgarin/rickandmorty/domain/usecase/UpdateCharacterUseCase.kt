package com.dpulgarin.rickandmorty.domain.usecase

import com.dpulgarin.rickandmorty.data.repository.CharacterRepository
import javax.inject.Inject

class UpdateCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository,
) {
    suspend operator fun invoke(id: Int) {
        repository.updateFavoriteCharacter(id)
    }
}
