package com.open6.taleadventure.presentation.tale.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.open6.taleadventure.databinding.ItemChapterBinding
import com.open6.taleadventure.presentation.tale.adapter.ChapterAdapter.ChapterViewHolder
import com.open6.taleadventure.presentation.tale.model.Chapter
import com.open6.taleadventure.util.DiffUtilCallback

class ChapterAdapter : ListAdapter<Chapter, ChapterViewHolder>(DiffUtilCallback<Chapter>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val binding = ItemChapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ChapterViewHolder(binding)
    }

    class ChapterViewHolder(val binding: ItemChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(itemList: List<Chapter>, position: Int) {
            setData(itemList, position)
            setViews(itemList, position)
        }

        private fun setData(itemList: List<Chapter>, position: Int) {
            with(binding) {
                ivChapter.load(itemList[position].imgUrl)
                tvChapterNumber.text = itemList[position].number.toString()
                tvChapterTitle.text = itemList[position].title
            }
        }

        private fun setViews(itemList: List<Chapter>, position: Int) {
            setTopBarViewVisibility(position)
            setBottomBarViewVisibility(position, itemList)
        }

        private fun setTopBarViewVisibility(position: Int) {
            if (position == 0) binding.viewChapterTopBar.visibility = View.INVISIBLE

        }

        private fun setBottomBarViewVisibility(position: Int, itemList: List<Chapter>) {
            if (position == itemList.lastIndex) binding.viewChapterBottomBar.visibility =
                View.INVISIBLE
        }
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.onBind(currentList, position)
    }
}