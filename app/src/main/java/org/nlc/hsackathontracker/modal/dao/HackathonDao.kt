package org.nlc.hsackathontracker.modal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.nlc.hsackathontracker.modal.data.Hackathon

@Dao
interface HackathonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHackathon(hackathon: Hackathon)

    @Query("SELECT * FROM hackathons")
    fun getAllHackathons(): LiveData<List<Hackathon>>
}


