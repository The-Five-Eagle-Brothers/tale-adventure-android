package com.taleadventure.teamfiveeagles.util

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem === newItem

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
}