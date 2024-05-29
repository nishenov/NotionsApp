package com.example.notionsapp.ui.activity


import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.notionsapp.R
import com.example.notionsapp.databinding.ActivityMainBinding
import com.example.notionsapp.ui.fragment.chat.ChatFragment
import com.example.notionsapp.util.PreferenceHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: PreferenceHelper
    private var isSwitched = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = PreferenceHelper().unit(this)

        if (!sharedPreferences.isOnBoardShow&&!sharedPreferences.isSignedIn) {
            findNavController(R.id.nav_host_fragment).navigate(R.id.onboardFragment)
            sharedPreferences.isOnBoardShow = true
        }
        else if (!sharedPreferences.isOnBoardShow == false && !sharedPreferences.isSignedIn){
            findNavController(R.id.nav_host_fragment).navigate(R.id.signUpFragment)
            sharedPreferences.isSignedIn = true
        }
        else {
            findNavController(R.id.nav_host_fragment).navigate(R.id.noteFragment)
        }
        val menu : View = findViewById(R.id.img_menu)
        menu.setOnClickListener{
            binding.main.openDrawer(androidx.core.view.GravityCompat.START)
        }
        binding.btnSwitch.setOnClickListener{
            if (!isSwitched){
                isSwitched = !isSwitched
                findNavController(R.id.nav_host_fragment).navigate(R.id.chatFragment)
                binding.main.closeDrawer(androidx.core.view.GravityCompat.START)
            }
            else{
                isSwitched = !isSwitched
                findNavController(R.id.nav_host_fragment).navigate(R.id.noteFragment)
                binding.main.closeDrawer(androidx.core.view.GravityCompat.START)
            }
        }
    }
}