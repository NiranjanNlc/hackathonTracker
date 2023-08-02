package org.nlc.hsackathontracker.modal.repo


import org.nlc.hsackathontracker.modal.dao.HackathonProjectDao
import org.nlc.hsackathontracker.modal.data.HackathonProject
import org.nlc.hsackathontracker.modal.db.AppDatabase
import javax.inject.Inject

class HackathonProjectRepository @Inject constructor(val hackathonProjectDao: HackathonProjectDao) {


//    fun getProjectsForHackathon(hackathonId: Long): LiveData<List<HackathonProject>> {
//        return hackathonProjectDao.getProjectsForHackathon(hackathonId)
//    }

    suspend fun insertHackathonProject(hackathonProject: HackathonProject) {
        hackathonProjectDao.insertHackathonProject(hackathonProject)
    }
}
