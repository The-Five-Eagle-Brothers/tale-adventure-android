package com.taleadventure.teamfiveeagles.presentation.category.age

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.taleadventure.teamfiveeagles.databinding.FragmentCategoryAgeBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseViewBindingFragment

class CategoryAgeFragment : BaseViewBindingFragment<FragmentCategoryAgeBinding>() {

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentCategoryAgeBinding = FragmentCategoryAgeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}