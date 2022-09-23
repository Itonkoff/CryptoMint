package com.kofu.brighton.cryptomint.di

import android.content.Context
import com.kofu.brighton.cryptomint.data.Repository
import com.kofu.brighton.cryptomint.data.room.DAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(dao: DAO, @ApplicationContext context: Context): Repository {
        return Repository(dao, context)
    }
}