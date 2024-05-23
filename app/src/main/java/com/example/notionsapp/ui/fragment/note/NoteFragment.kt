package com.example.notionsapp.ui.fragment.note

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notionsapp.App
import com.example.notionsapp.R
import com.example.notionsapp.data.extensions.getBackStackData
import com.example.notionsapp.data.models.NoteModel
import com.example.notionsapp.databinding.FragmentNoteBinding
import com.example.notionsapp.interfaces.OnClickItem
import com.example.notionsapp.ui.adapter.NoteAdapter

class NoteFragment : Fragment(), OnClickItem {
    private lateinit var binding: FragmentNoteBinding
    private val noteAdapter = NoteAdapter(this, this)
    private var isGridLayout = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListeners()
        getData()
    }

    private fun initialize() {
        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun setUpListeners() {
        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailedFragment)
        }
        binding.imgChangeLayout.setOnClickListener{
            isGridLayout = !isGridLayout
            val layoutManager = if (isGridLayout){
                GridLayoutManager(requireContext(),2)
            }
            else{
                LinearLayoutManager(requireContext())
            }
            binding.rvNotes.layoutManager = layoutManager
        }
    }

    private fun getData(){
        App().getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner){
            noteAdapter.submitList(it)
        }
    }

    override fun onLongClick(noteModel: NoteModel) {
        val builder = AlertDialog.Builder(requireContext())
        with(builder){
            setTitle(getString(R.string.delete_question))
            setPositiveButton("Да"){dialog, which ->
                App().getInstance()?.noteDao()?.deleteNote(noteModel)
            }
            setNegativeButton("Нет"){dialog, which ->
                dialog.cancel()
            }
            show()
        }
        builder.create()
    }

    override fun onClick(noteModel: NoteModel) {
        val action = NoteFragmentDirections.actionNoteFragmentToNoteDetailedFragment(noteModel.id)
        findNavController().navigate(action)
    }
}