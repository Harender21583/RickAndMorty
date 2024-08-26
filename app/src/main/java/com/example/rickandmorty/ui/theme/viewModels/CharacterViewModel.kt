package com.example.rickandmorty.ui.theme.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.ui.theme.api.API
import com.example.rickandmorty.ui.theme.dataClass.characters_entity.CharactersEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val api: API) : ViewModel() {
    private val _characters: MutableStateFlow<CharactersEntity> =
        MutableStateFlow(CharactersEntity.empty())
    val characters get() = _characters

    init {
        getCharacterList()
    }

    private fun getCharacterList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = api.getCharactersList()
            if (response.isSuccessful){
                _characters.value=response.body()?: CharactersEntity.empty()
            }else{
                _characters.value= CharactersEntity.empty()
            }


        }
    }

}