package com.example.androidstudy_music.di

import com.example.androidstudy_music.data.music.MusicRepository
import com.example.androidstudy_music.data.music.MusicRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMusicRepository(impl: MusicRepositoryImpl) : MusicRepository
}
