package org.nlc.hsackathontracker.modal.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// HackathonEntity.kt


@Entity(tableName = "hackathons")
data class Hackathon(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val hackathonName: String,
    val date: String,
    val location: String,
    val organizer: String,
    val projectName: String,
    val technologiesUsed: String,
    val projectDescription: String,
)
