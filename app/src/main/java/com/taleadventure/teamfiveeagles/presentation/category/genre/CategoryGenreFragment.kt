package com.taleadventure.teamfiveeagles.presentation.category.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taleadventure.teamfiveeagles.databinding.FragmentCategoryGenreBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseViewBindingFragment

class CategoryGenreFragment : BaseViewBindingFragment<FragmentCategoryGenreBinding>() {

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentCategoryGenreBinding =
        FragmentCategoryGenreBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}