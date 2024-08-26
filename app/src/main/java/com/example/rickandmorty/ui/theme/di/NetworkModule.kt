package com.example.rickandmorty.ui.theme.di

import com.example.rickandmorty.ui.theme.api.API
import com.example.rickandmorty.ui.theme.constents.Env
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun retrofitInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Env.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun rickAndMortyAPI(retrofit: Retrofit):API{
        return retrofit.create(API::class.java)
    }
}