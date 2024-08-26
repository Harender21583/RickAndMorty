package com.example.rickandmorty.ui.theme.api

import com.example.rickandmorty.ui.theme.constents.URLs
import com.example.rickandmorty.ui.theme.dataClass.characters_entity.CharacterDetail
import com.example.rickandmorty.ui.theme.dataClass.characters_entity.CharactersEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET(URLs.CHARACTERS)
    suspend fun getCharactersList(): Response<CharactersEntity>

    @GET("${URLs.CHARACTERS}/{id}")
    suspend fun getCharacterDetail(@Path("id") id: String): Response<CharacterDetail>
}