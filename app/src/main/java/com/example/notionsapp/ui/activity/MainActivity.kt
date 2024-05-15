package com.example.notionsapp.ui.activity


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.notionsapp.R
import com.example.notionsapp.util.PreferenceHelper

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: PreferenceHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        sharedPreferences = PreferenceHelper().unit(this)

        if (!sharedPreferences.isOnBoardShow) {
            findNavController(R.id.nav_host_fragment).navigate(R.id.onboardFragment)
            sharedPreferences.isOnBoardShow = true
        } else {
            findNavController(R.id.nav_host_fragment).navigate(R.id.noteFragment)
        }
    }
}