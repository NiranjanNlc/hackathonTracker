package org.nlc.hsackathontracker.modal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.nlc.hsackathontracker.modal.data.HackathonProject

@Dao
interface HackathonProjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHackathonProject(hackathonProject: HackathonProject)

    @Query("SELECT * FROM hack_projects WHERE hackathonId = :hackathonId")
    fun getProjectsForHackathon(hackathonId: Long): List<HackathonProject>
}