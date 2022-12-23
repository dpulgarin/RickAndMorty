package com.dpulgarin.rickandmorty.data.di

import com.dpulgarin.rickandmorty.data.repository.CharacterRepository
import com.dpulgarin.rickandmorty.data.repository.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    @ViewModelScoped
    fun provideCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository
}
