package com.open6.taleadventure.presentation.end.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.open6.taleadventure.data.remote.model.word.ResponseGameWordsDto
import com.open6.taleadventure.databinding.ItemGameScoreBinding
import com.open6.taleadventure.util.DiffUtilCallback

class WordsAdapter :
    ListAdapter<ResponseGameWordsDto, WordsAdapter.WordsViewHolder>(DiffUtilCallback<ResponseGameWordsDto>()) {
    private var onItemClick: ((Int, Boolean) -> Unit)? = null
    fun setOnItemClick(onClick: (Int, Boolean) -> Unit) {
        onItemClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val binding =
            ItemGameScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordsViewHolder(binding, onItemClick)
    }

    class WordsViewHolder(
        val binding: ItemGameScoreBinding,
        private val onClick: ((Int, Boolean) -> Unit)?,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(itemList: List<ResponseGameWordsDto>, position: Int) {
            setViews(itemList[position])
            setClickEvents(position, binding.ivItemGameScoreBookmark.isSelected)
        }

        private fun setClickEvents(position: Int, currentlyBookmarked: Boolean) {
            onClick?.invoke(position, !currentlyBookmarked)
        }

        private fun setViews(word: ResponseGameWordsDto) {
            with(binding) {
                tvItemGameScoreWord.text = word.name
                tvItemGameScoreDesc.text = word.mean
                ivItemGameScoreBookmark.isSelected = word.bookMark
            }
        }
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.onBind(currentList, position)
    }
}