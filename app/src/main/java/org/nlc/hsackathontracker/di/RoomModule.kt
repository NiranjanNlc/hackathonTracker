package org.nlc.hsackathontracker.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nlc.hsackathontracker.modal.dao.HackathonDao
import org.nlc.hsackathontracker.modal.dao.HackathonProjectDao
import org.nlc.hsackathontracker.modal.db.AppDatabase

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun provideDataBase(context: Context) : AppDatabase {
        return  AppDatabase.getInstance(context )
    }
    @Provides
    fun provideHackathonDao(appDatabase: AppDatabase): HackathonDao = appDatabase.hackathonDao()

    @Provides
    fun provideprojetcDao(appDatabase: AppDatabase): HackathonProjectDao = appDatabase.hackathonProjectDao()






}