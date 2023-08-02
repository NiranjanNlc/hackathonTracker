package org.nlc.hsackathontracker.modal.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "hack_projects", foreignKeys = [ForeignKey(entity = Hackathon::class, parentColumns = ["id"], childColumns = ["hackathonId"], onDelete = ForeignKey.CASCADE)])
data class HackathonProject(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val projectName: String,
    val teamMembers: List<String>,
    val technologiesUsed: List<String>,
    val description: String,
    val hackathonId: Long // Foreign key referencing the HackathonEntity
)
