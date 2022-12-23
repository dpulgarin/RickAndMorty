package com.dpulgarin.rickandmorty.ui.screens.characterlocation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpulgarin.rickandmorty.domain.vo.Resource
import com.dpulgarin.rickandmorty.domain.usecase.GetCharacterLocationUseCase
import com.dpulgarin.rickandmorty.ui.navigation.NavArg
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CharacterLocationViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getCharacterLocationUseCase: GetCharacterLocationUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterLocationState())
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
                    _state.value = CharacterLocationState(characterLocationResult = result.data)
                }
                is Resource.Failure -> {
                    _state.value = CharacterLocationState(error = result.e.message)
                }
                is Resource.Loading -> {
                    _state.value = CharacterLocationState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
