package com.dpulgarin.rickandmorty.di

import com.dpulgarin.rickandmorty.repository.CharacterRepository
import com.dpulgarin.rickandmorty.repository.CharacterRepositoryImpl
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
