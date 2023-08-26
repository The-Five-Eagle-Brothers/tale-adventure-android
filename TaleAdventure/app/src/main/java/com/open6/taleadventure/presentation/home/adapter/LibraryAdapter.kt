package com.open6.taleadventure.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.ItemLibraryBinding
import com.open6.taleadventure.presentation.home.adapter.LibraryAdapter.LibraryViewHolder
import com.open6.taleadventure.presentation.home.model.Library
import com.open6.taleadventure.util.DiffUtilCallback

class LibraryAdapter : ListAdapter<Library, LibraryViewHolder>(DiffUtilCallback<Library>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryViewHolder {
        val binding = ItemLibraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return LibraryViewHolder(binding)
    }

    class LibraryViewHolder(val binding: ItemLibraryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(itemList: List<Library>, position: Int) {
            setData(itemList, position)
            setMargin(itemList, position)
        }

        private fun setData(itemList: List<Library>, position: Int) {
            with(binding) {
                ivItemLibrary.load(itemList[position].imgUrl)
                tvItemLibraryTitle.text = itemList[position].title
            }
        }

        private fun setMargin(itemList: List<Library>, position: Int) {
            val newMarginInPx =
                binding.root.resources.getDimensionPixelSize(R.dimen.library_item_margin)

            setStartItemMargin(newMarginInPx, position)
            setLastItemMargin(newMarginInPx, position, itemList)
        }

        private fun setStartItemMargin(newMarginInPx: Int, position: Int) {
            val firstLayoutParams =
                binding.tvItemLibraryTitle.layoutParams as ViewGroup.MarginLayoutParams
            firstLayoutParams.setMargins(newMarginInPx, 0, 0, 0)

            if (position == 0) {
                with(binding) {
                    ivItemLibrary.layoutParams = firstLayoutParams
                    tvItemLibraryTitle.layoutParams = firstLayoutParams
                }
            }
        }

        private fun setLastItemMargin(newMarginInPx: Int, position: Int, itemList: List<Library>) {
            val lastLayoutParams =
                binding.tvItemLibraryTitle.layoutParams as ViewGroup.MarginLayoutParams
            lastLayoutParams.setMargins(0, 0, 0, newMarginInPx)

            if (position == itemList.lastIndex) {
                with(binding) {
                    ivItemLibrary.layoutParams = lastLayoutParams
                    tvItemLibraryTitle.layoutParams = lastLayoutParams
                }
            }
        }
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        holder.onBind(currentList, position)
    }
}