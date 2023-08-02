package org.nlc.hsackathontracker.viewmodal


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.nlc.hsackathontracker.modal.data.HackathonProject
import org.nlc.hsackathontracker.modal.repo.HackathonProjectRepository
import javax.inject.Inject

@HiltViewModel
class HackathonProjectViewModal @Inject constructor
    (val  hackathonProjectRepository: HackathonProjectRepository) : ViewModel()
{

    // Method to insert a new hackathon project
    fun insertHackathonProject(hackathonProject: HackathonProject) {
        viewModelScope.launch(Dispatchers.IO) {
            hackathonProjectRepository.insertHackathonProject(hackathonProject)
        }
    }
}
