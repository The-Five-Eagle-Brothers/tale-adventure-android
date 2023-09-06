package com.open6.taleadventure.presentation.tale.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.open6.taleadventure.data.remote.model.chapter.ResponseChapterDto
import com.open6.taleadventure.databinding.ItemChapterBinding
import com.open6.taleadventure.presentation.tale.adapter.ChapterAdapter.ChapterViewHolder
import com.open6.taleadventure.util.DiffUtilCallback

class ChapterAdapter :
    ListAdapter<ResponseChapterDto, ChapterViewHolder>(DiffUtilCallback<ResponseChapterDto>()) {
    private var onItemClick: ((String) -> Unit)? = null
    fun setOnItemClick(onClick: (String) -> Unit) {
        onItemClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val binding = ItemChapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ChapterViewHolder(binding, onItemClick)
    }

    class ChapterViewHolder(
        val binding: ItemChapterBinding, private val onItemClick: ((String) -> Unit)?,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(itemList: List<ResponseChapterDto>, position: Int) {
            setData(itemList, position)
            setViews(itemList, position)
            setClickEvents()
        }

        private fun setClickEvents() {
            binding.layoutChapterItem.setOnClickListener {
                onItemClick?.invoke(binding.tvChapterTitle.text.toString())
            }
        }

        private fun setData(itemList: List<ResponseChapterDto>, position: Int) {
            with(binding) {
                ivChapter.load(itemList[position].imageUrl)
                tvChapterNumber.text = position.plus(1).toString()
                tvChapterTitle.text = itemList[position].title
            }
        }

        private fun setViews(itemList: List<ResponseChapterDto>, position: Int) {
            setTopBarViewVisibility(position)
            setBottomBarViewVisibility(position, itemList)
        }

        private fun setTopBarViewVisibility(position: Int) {
            if (position == 0) binding.viewChapterTopBar.visibility = View.INVISIBLE

        }

        private fun setBottomBarViewVisibility(position: Int, itemList: List<ResponseChapterDto>) {
            if (position == itemList.lastIndex) binding.viewChapterBottomBar.visibility =
                View.INVISIBLE
        }
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.onBind(currentList, position)
    }
}