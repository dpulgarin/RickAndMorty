package com.dpulgarin.rickandmorty.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpulgarin.rickandmorty.core.Resource
import com.dpulgarin.rickandmorty.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(CharactersState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCharacters()
        }
    }

    private fun getCharacters() {
        getCharactersUseCase().onEach { result->
            when(result) {
                is Resource.Success -> {
                    _state.value = CharactersState(characters = result.data)
                }
                is Resource.Failure -> {
                    _state.value = CharactersState(error = result.e.message)
                }
                is Resource.Loading -> {
                    _state.value = CharactersState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
