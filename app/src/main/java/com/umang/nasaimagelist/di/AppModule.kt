package com.umang.nasaimagelist.di

import com.umang.nasaimagelist.data.NasaRepository
import com.umang.nasaimagelist.data.NasaRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindNasaRepository(
        nasaRepositoryImpl: NasaRepositoryImpl
    ): NasaRepository


}