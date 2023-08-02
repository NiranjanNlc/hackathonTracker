package org.nlc.hsackathontracker.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import org.nlc.hsackathontracker.R
import org.nlc.hsackathontracker.databinding.FragmentWelcomeBinding
import org.nlc.hsackathontracker.view.adapter.HackathonAdapter
import org.nlc.hsackathontracker.viewmodal.HackathonViewModal

// WelcomeFragment.kt
@AndroidEntryPoint
class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private val  viewModel: HackathonViewModal by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using Data Binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        Log.i("startk", "done ")
        Log.i("startk", "done  on create ciew ")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize the ViewModel'
        try {
            Log.i("startk", "done  view created $viewModel")

            // Set the ViewModel as a variable for Data Binding
            Log.i("startk", "done  view created  ${viewModel}i")

            binding.lifecycleOwner = this // Set the lifecycle owner for LiveData updates
        }
        catch (e:Exception)
        {
            Log.i("startk",e.message.toString())
        }

        // Set up RecyclerView
        val hackathonAdapter = HackathonAdapter { hackathon ->
            // Handle item click
            // Here, you can navigate to the HackathonDetailFragment
            // and pass the hackathonId as an argument if needed
        }
        binding.hackathonRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = hackathonAdapter
        }

        Log.i("startk", "done  view created ")
        // Observe the list of hackathons from the ViewModel
        viewModel.hackathons.observe(viewLifecycleOwner) { hackathons ->
            hackathonAdapter.submitList(hackathons)
            Log.i("startk", "done  view created  observed $hackathons ")
        }
        Log.i("startk", "done  view created  observed ")

        // Set the click listener for FAB
        binding.addHackathonFab.setOnClickListener {
            // Show the HackathonAddFragment (DialogFragment)
            val hackathonAddFragment = HackathonAdd()
            hackathonAddFragment.show(parentFragmentManager, "HackathonAddFragment")
        }
    }
}

