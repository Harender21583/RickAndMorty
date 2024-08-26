package com.example.rickandmorty.ui.theme.dataClass.characters_entity

data class CharactersEntity(
    val info: Info,
    val results: List<Result>
){
    companion object{
        fun empty():CharactersEntity{
            return  CharactersEntity(Info(0,"",0), emptyList())
        }
    }
}