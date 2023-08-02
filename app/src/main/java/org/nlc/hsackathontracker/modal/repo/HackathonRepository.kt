package org.nlc.hsackathontracker.modal.repo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.nlc.hsackathontracker.modal.dao.HackathonDao
import org.nlc.hsackathontracker.modal.data.Hackathon
import org.nlc.hsackathontracker.modal.db.AppDatabase
import javax.inject.Inject

class HackathonRepository @Inject constructor (private val hackathonDao: HackathonDao) {

    val allHackathons: LiveData<List<Hackathon>> = hackathonDao.getAllHackathons()

    suspend fun insertHackathon(hackathon: Hackathon) {
            hackathonDao.insertHackathon(hackathon)
    }

}