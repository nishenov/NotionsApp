package com.example.notionsapp.ui.fragment.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notionsapp.R
import com.example.notionsapp.databinding.FragmentChatBinding
import com.example.notionsapp.ui.adapter.ChatAdapter
import com.google.firebase.Firebase
import com.google.firebase.firestore.ListenerRegistration
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore

class ChatFragment : Fragment() {
    private lateinit var binding: FragmentChatBinding
    private val chatAdapter = ChatAdapter()
    private val db = Firebase.firestore
    private lateinit var query: Query
    private lateinit var listener: ListenerRegistration
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListeners()
        observeMessages()
    }

    private fun initialize() {
        binding.rvChat.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = chatAdapter
        }
    }

    private fun setUpListeners() {
        binding.btnSend.setOnClickListener{
            val user = hashMapOf(
                "name" to binding.etChat.text.toString()
            )
            db.collection("user").add(user).addOnCompleteListener{}
            binding.etChat.text.clear()
        }
    }

    private fun observeMessages() {
        query = db.collection("user")
        listener = query.addSnapshotListener{value, error->
            if (error != null){
                return@addSnapshotListener
            }
            value?.let {snapshot->
                val messages = mutableListOf<String>()
                for(doc in snapshot.documents){
                    val message = doc.getString("name")
                    message?.let {
                        messages.add(it)
                    }
                }
                chatAdapter.submitList(messages)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        listener.remove()
    }
}

