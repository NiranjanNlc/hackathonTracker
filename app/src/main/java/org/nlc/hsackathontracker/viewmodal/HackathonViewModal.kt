package org.nlc.hsackathontracker.viewmodal

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.nlc.hsackathontracker.App
import org.nlc.hsackathontracker.modal.dao.HackathonDao
import org.nlc.hsackathontracker.modal.data.Hackathon
import org.nlc.hsackathontracker.modal.db.AppDatabase
import org.nlc.hsackathontracker.modal.repo.HackathonRepository
import javax.inject.Inject

@HiltViewModel
class HackathonViewModal @Inject constructor( val hackathonRepository: HackathonRepository) : ViewModel() {


        val hackathons: LiveData<List<Hackathon>> = hackathonRepository.allHackathons

        private val _queryText = MutableLiveData<String?>()

        fun onQueryTextChange(query: String?): Boolean {
            _queryText.value = query
            return true
        }

        init {
            _queryText.value = ""
        }

        fun addHackaThoan(hackathon: Hackathon)
        {
            viewModelScope.launch(Dispatchers.IO) {
                hackathonRepository.insertHackathon(hackathon)
            }
        }
    }

