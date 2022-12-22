package com.dpulgarin.rickandmorty.ui.screens.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpulgarin.rickandmorty.core.Resource
import com.dpulgarin.rickandmorty.domain.GetCharacterLocationUseCase
import com.dpulgarin.rickandmorty.ui.navigation.NavArg
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterLocationUseCase: GetCharacterLocationUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterDetailState())
    val state = _state.asStateFlow()

    init {
        savedStateHandle.get<Int>(NavArg.LocationId.key)?.let { locationId ->
            getCharacterLocation(locationId)
        }
    }

    private fun getCharacterLocation(locationId: Int) {
        getCharacterLocationUseCase(locationId).onEach { result->
            when(result) {
                is Resource.Success -> {
                    _state.value = CharacterDetailState(characterLocation = result.data)
                }
                is Resource.Failure -> {
                    _state.value = CharacterDetailState(error = result.e.message)
                }
                is Resource.Loading -> {
                    _state.value = CharacterDetailState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
