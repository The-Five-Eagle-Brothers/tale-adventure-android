package com.open6.taleadventure.presentation.dailyadventure.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.ItemCloudLeftBinding
import com.open6.taleadventure.databinding.ItemCloudRightBinding
import com.open6.taleadventure.presentation.dailyadventure.list.model.DailyAdventure
import com.open6.taleadventure.util.DiffUtilCallback
import com.open6.taleadventure.util.PublicInt.EVEN
import com.open6.taleadventure.util.PublicInt.ODD
import com.open6.taleadventure.util.extensions.isOdd

class DailyAdventureListAdapter(private val navigateToDailyAdventureGameActivity: () -> Unit) :
    ListAdapter<DailyAdventure, RecyclerView.ViewHolder>(DiffUtilCallback<DailyAdventure>()) {


    override fun getItemViewType(position: Int): Int = if (currentList[position].day.isOdd) ODD
    else EVEN

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ODD) {
            val binding =
                ItemCloudLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            CloudLeftViewHolder(binding, navigateToDailyAdventureGameActivity)
        } else {
            val binding =
                ItemCloudLeftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            CloudLeftViewHolder(binding, navigateToDailyAdventureGameActivity)
        }
    }

    class CloudLeftViewHolder(
        private val binding: ItemCloudLeftBinding,
        private val navigateToDailyAdventureGameActivity: () -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: DailyAdventure, position: Int, lastIndex: Int) {
            setData(item)
            setView(position, lastIndex)
            setClickEvent()
        }

        private fun setClickEvent() {
            binding.btnCloudLeftPlay.setOnClickListener {
                navigateToDailyAdventureGameActivity.invoke()
            }
        }

        private fun setView(position: Int, lastIndex: Int) {
            if (position == lastIndex) binding.btnCloudLeftPlay.visibility = View.VISIBLE
        }

        private fun setData(item: DailyAdventure) {
            binding.tvCloudLeftDay.text =
                binding.root.context.getString(R.string.daily_adventure_day, item.day.toString())
        }
    }

    class CloudRightViewHolder(
        private val binding: ItemCloudRightBinding,
        private val navigateToDailyAdventureGameActivity: () -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: DailyAdventure, position: Int, lastIndex: Int) {
            setData(item)
            setView(position, lastIndex)
            setClickEvent()
        }

        private fun setClickEvent() {
            binding.btnCloudRightPlay.setOnClickListener {
                navigateToDailyAdventureGameActivity.invoke()
            }
        }

        private fun setView(position: Int, lastIndex: Int) {
            if (position == lastIndex) binding.ivCloudRightCloud.visibility = View.VISIBLE
        }

        private fun setData(item: DailyAdventure) {
            binding.tvCloudRightDay.text =
                binding.root.context.getString(R.string.daily_adventure_day, item)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CloudLeftViewHolder -> holder.onBind(
                currentList[position], position, currentList.lastIndex
            )

            is CloudRightViewHolder -> holder.onBind(
                currentList[position], position, currentList.lastIndex
            )
        }
    }
}