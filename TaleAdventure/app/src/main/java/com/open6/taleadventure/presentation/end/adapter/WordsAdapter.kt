package com.open6.taleadventure.presentation.end.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.open6.taleadventure.databinding.ItemGameScoreBinding
import com.open6.taleadventure.presentation.end.model.Word
import com.open6.taleadventure.util.DiffUtilCallback

class WordsAdapter : ListAdapter<Word, WordsAdapter.WordsViewHolder>(DiffUtilCallback<Word>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val binding =
            ItemGameScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordsViewHolder(binding)
    }

    class WordsViewHolder(val binding: ItemGameScoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(itemList: List<Word>, position: Int) {
            setViews(itemList[position])
        }

        private fun setViews(word: Word) {
            with(binding) {
                tvItemGameScoreWord.text = word.title
                tvItemGameScoreDesc.text = word.desc
                ivItemGameScoreBookmark.isSelected = word.isBookmarked
            }
        }
    }

    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        holder.onBind(currentList, position)
    }
}