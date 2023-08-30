package com.open6.taleadventure.presentation.myword.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.open6.taleadventure.databinding.ItemStoryBinding
import com.open6.taleadventure.presentation.myword.model.Story
import com.open6.taleadventure.util.DiffUtilCallback

class StoryAdapter : ListAdapter<Story, StoryAdapter.StoryViewHolder>(DiffUtilCallback<Story>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = ItemStoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return StoryViewHolder(binding)
    }

    class StoryViewHolder(private val binding: ItemStoryBinding) : ViewHolder(binding.root) {
        fun onBind(itemList: List<Story>, position: Int) {
            binding.ivItemLibrary.load(itemList[position])
        }
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.onBind(currentList, position)
    }
}