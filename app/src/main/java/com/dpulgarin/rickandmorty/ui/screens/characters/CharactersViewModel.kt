package com.dpulgarin.rickandmorty.ui.screens.characters

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dpulgarin.rickandmorty.domain.vo.Resource
import com.dpulgarin.rickandmorty.domain.usecase.GetCharactersUseCase
import com.dpulgarin.rickandmorty.domain.usecase.UpdateCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val updateCharacterUseCase: UpdateCharacterUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(CharactersState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCharacters()
        }
    }

    private fun getCharacters() {
        getCharactersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CharactersState(characterResult = result.data)
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

    fun getLocationIdFromUri(uri: Uri): Int = uri.lastPathSegment?.toInt() ?: run { 0 }

    fun setFavouriteId(id: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            updateCharacterUseCase(id)
            getCharacters()
        }
    }
}
