package org.nlc.hsackathontracker.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.nlc.hsackathontracker.R
import org.nlc.hsackathontracker.databinding.FragmentHackathonAddBinding
import org.nlc.hsackathontracker.modal.data.Hackathon
import org.nlc.hsackathontracker.viewmodal.HackathonViewModal
import kotlin.random.Random

@AndroidEntryPoint
class HackathonAdd : DialogFragment() {

    private lateinit var binding: FragmentHackathonAddBinding
    private val  viewModel: HackathonViewModal by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hackathon_add, container, false)
        binding.lifecycleOwner = this // Set the lifecycle owner for LiveData updates
        binding.addHackathonFab.setOnClickListener {
            val hackathonName: String = binding.hackathonName.getText().toString()
            val hackathonDate: String = binding.hackathonDate.getText().toString()
            val hackathonLocation: String = binding.hackathonLocation.getText().toString()
            val hackathonOrganizer: String = binding.hackathonOrganizer.getText().toString()
            val projectName: String = binding.projectName.getText().toString()
            val technologiesUsed: String = binding.technologiesUsed.getText().toString()
            val projectDescription: String = binding.projectDescription.getText().toString()
             val hackathon = Hackathon(
                 Random(17800) .nextLong(),
                 hackathonName,
                 hackathonDate,
                 hackathonLocation,
                 hackathonOrganizer,
                 projectName,
                 technologiesUsed,
                 projectDescription
             )
            viewModel.addHackaThoan(hackathon )
            dismiss()
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // Set the dialog size here
        dialog?.window?.apply {
            val params = attributes
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            attributes = params
        }
    }
}
