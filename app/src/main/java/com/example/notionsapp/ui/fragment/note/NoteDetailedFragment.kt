package com.example.notionsapp.ui.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.notionsapp.App
import com.example.notionsapp.R
import com.example.notionsapp.data.extensions.setBackStackData
import com.example.notionsapp.data.models.NoteModel
import com.example.notionsapp.databinding.FragmentNoteDetailedBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class NoteDetailedFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailedBinding
    private var textColor: Int = R.color.dark_orange
    private var backgroundColor: Int = R.color.brown
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNoteDetailedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnBlack.setOnClickListener{
            textColor = R.color.light_grey
            backgroundColor = R.color.light_black
            binding.tvDone.visibility = View.VISIBLE
        }
        binding.btnWhite.setOnClickListener{
            textColor = R.color.yellow
            backgroundColor = R.color.white_old
            binding.tvDone.visibility = View.VISIBLE
        }
        binding.btnBrown.setOnClickListener{
            textColor = R.color.orange
            backgroundColor = R.color.brown
            binding.tvDone.visibility = View.VISIBLE
        }
        binding.tvDone.setOnClickListener{
            val etHeader = binding.etHeader.text.toString()
            val etDescription = binding.etDescription.text.toString()
            val currentTime = getCurrentDateTime()
            App().getInstance()?.noteDao()?.insertNote(NoteModel(etHeader, etDescription, currentTime, textColor, backgroundColor))
            findNavController().navigateUp()
        }
        binding.imgBackArrow.setOnClickListener{
            findNavController().navigateUp()
        }
    }

    private fun getCurrentDateTime(): String {
        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd MMM HH:mm", Locale.getDefault())
        return dateFormat.format(cal.time)
    }
}