package com.taleadventure.teamfiveeagles.presentation.category.view

import android.view.LayoutInflater
import com.taleadventure.teamfiveeagles.databinding.ActivityCategoryBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseViewBindingActivity

class CategoryActivity : BaseViewBindingActivity<ActivityCategoryBinding>() {

    override fun setBinding(layoutInflater: LayoutInflater): ActivityCategoryBinding =
        ActivityCategoryBinding.inflate(layoutInflater)
}