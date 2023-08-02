package org.nlc.hsackathontracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.nlc.hsackathontracker.modal.dao.HackathonDao
import org.nlc.hsackathontracker.modal.dao.HackathonProjectDao
import org.nlc.hsackathontracker.modal.repo.HackathonProjectRepository
import org.nlc.hsackathontracker.modal.repo.HackathonRepository

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {


    @Provides
    fun provideHackathonRepo(hackathonDao: HackathonDao) = HackathonRepository(hackathonDao)

    @Provides
    fun provideHackathonProjectRepo(projectDao: HackathonProjectDao) = HackathonProjectRepository(projectDao)

}