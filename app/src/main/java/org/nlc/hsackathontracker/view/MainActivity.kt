package org.nlc.hsackathontracker.view

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint
import org.nlc.hsackathontracker.R
import org.nlc.hsackathontracker.databinding.ActivityMainBinding
import org.nlc.hsackathontracker.view.fragment.WelcomeFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            Log.i("startk", "on ceatung ")
            binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
            Log.i("startk", "on binding ")
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            try {
                val welcomeFragment = WelcomeFragment()
                fragmentTransaction.replace(R.id.fragmentContainer, welcomeFragment)
                fragmentTransaction.commitAllowingStateLoss()
            } catch (e: Exception) {
                Log.i("startk", e.message.toString())
                // Handle the exception, log, or perform appropriate error handling.
            }

        }
    }
