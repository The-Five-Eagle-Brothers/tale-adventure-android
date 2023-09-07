package com.open6.taleadventure.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.open6.taleadventure.R
import com.open6.taleadventure.data.remote.model.home.ResponseHomeDto.TaleBook
import com.open6.taleadventure.databinding.ItemLibraryBinding
import com.open6.taleadventure.presentation.home.adapter.LibraryAdapter.LibraryViewHolder
import com.open6.taleadventure.util.DiffUtilCallback

class LibraryAdapter : ListAdapter<TaleBook, LibraryViewHolder>(DiffUtilCallback<TaleBook>()) {
    private var onItemClick: ((String) -> Unit)? = null
    fun setOnItemClick(onClick: (String) -> Unit) {
        onItemClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val binding = ItemLibraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return LibraryViewHolder(binding, onItemClick)
    }

    class LibraryViewHolder(
        val binding: ItemLibraryBinding,
        private val onItemClick: ((String) -> Unit)?,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(itemList: List<TaleBook>, position: Int) {
            setData(itemList, position)
            setMargin(itemList, position)
            setClickEvent(itemList[position])
        }

        private fun setClickEvent(item: TaleBook) {
            binding.ivItemLibrary.setOnClickListener {
                onItemClick?.invoke(item.name)
            }
        }

        private fun setData(itemList: List<TaleBook>, position: Int) {
            with(binding) {
                ivItemLibrary.load(itemList[position].libraryImageUrl)
                tvItemLibraryTitle.text = itemList[position].name
            }
        }

        private fun setMargin(itemList: List<TaleBook>, position: Int) {
            val newMarginInPx =
                binding.root.resources.getDimensionPixelSize(R.dimen.library_item_margin)

            setStartItemMargin(newMarginInPx, position)
            setLastItemMargin(newMarginInPx, position, itemList)
        }

        private fun setStartItemMargin(newMarginInPx: Int, position: Int) {
            val firstLayoutParams =
                binding.root.layoutParams as ViewGroup.MarginLayoutParams
            firstLayoutParams.setMargins(newMarginInPx, 0, 0, 0)

            if (position == 0) {
                with(binding) {
                    root.layoutParams = firstLayoutParams
                }
            }
        }

        private fun setLastItemMargin(newMarginInPx: Int, position: Int, itemList: List<TaleBook>) {
            val lastLayoutParams =
                binding.root.layoutParams as ViewGroup.MarginLayoutParams
            lastLayoutParams.setMargins(0, 0, 0, newMarginInPx)

            if (position == itemList.lastIndex) {
                with(binding) {
                    root.layoutParams = lastLayoutParams
                }
            }
        }
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        holder.onBind(currentList, position)
    }
}