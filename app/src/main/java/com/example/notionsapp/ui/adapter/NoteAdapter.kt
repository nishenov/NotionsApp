package com.example.notionsapp.ui.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.notionsapp.data.models.NoteModel
import com.example.notionsapp.databinding.ItemNoteBinding

class NoteAdapter : ListAdapter<NoteModel, NoteAdapter.ViewHolder>(DiffCallback()){
    class ViewHolder (private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: NoteModel) {
            binding.tvItemHeader.text = item.header
            binding.tvItemDescription.text = item.description
            binding.tvItemDate.text = item.date
            binding.tvItemHeader.setTextColor(ContextCompat.getColor(binding.root.context, item.textColor))
            binding.tvItemDescription.setTextColor(ContextCompat.getColor(binding.root.context, item.textColor))
            binding.tvItemDate.setTextColor(ContextCompat.getColor(binding.root.context, item.textColor))
            binding.root.setBackgroundColor(ContextCompat.getColor(binding.root.context, item.backgroundColor))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback: DiffUtil.ItemCallback<NoteModel>(){
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id

        }
    }
}