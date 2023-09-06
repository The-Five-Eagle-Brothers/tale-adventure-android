package com.open6.taleadventure.presentation.myword.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.open6.taleadventure.data.remote.model.myword.ResponseMyWordDto
import com.open6.taleadventure.databinding.ItemStoryBinding
import com.open6.taleadventure.util.DiffUtilCallback

class StoryAdapter :
    ListAdapter<ResponseMyWordDto, StoryAdapter.StoryViewHolder>(DiffUtilCallback<ResponseMyWordDto>()) {
    private var onItemClick: ((String) -> Unit)? = null
    fun setOnItemClick(onClick: (String) -> Unit) {
        onItemClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding = ItemStoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return StoryViewHolder(binding, onItemClick)
    }

    class StoryViewHolder(
        private val binding: ItemStoryBinding,
        private val onItemClick: ((String) -> Unit)?,
    ) : ViewHolder(binding.root) {
        fun onBind(itemList: List<ResponseMyWordDto>, position: Int) {
            itemList[position].run {
                setData()
                setClickEvents()
            }
        }

        private fun ResponseMyWordDto.setData() {
            binding.ivItemLibrary.load(this)
        }

        private fun ResponseMyWordDto.setClickEvents() {
            binding.ivItemLibrary.setOnClickListener {
                onItemClick?.invoke(this.name)
            }
        }
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.onBind(currentList, position)
    }
}