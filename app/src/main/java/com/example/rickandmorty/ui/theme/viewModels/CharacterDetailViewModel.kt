package com.example.rickandmorty.ui.theme.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.ui.theme.api.API
import com.example.rickandmorty.ui.theme.dataClass.characters_entity.CharacterDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val api: API,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _characterDetail: MutableStateFlow<CharacterDetail> =
        MutableStateFlow(CharacterDetail.empty())
    val characterDetail get() = _characterDetail

    init {
        val id = savedStateHandle.get<String>("id") ?: 1
        getCharacterDetail(id.toString())
    }

    private fun getCharacterDetail(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = api.getCharacterDetail(id)
            if (response.isSuccessful) {
                _characterDetail.value = response.body() ?: CharacterDetail.empty()
            } else {
                _characterDetail.value = CharacterDetail.empty()

            }
        }
    }
}