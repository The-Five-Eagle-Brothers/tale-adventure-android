package com.open6.taleadventure.presentation.tale.view

import android.os.Bundle
import android.view.LayoutInflater
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.ActivityTaleBinding
import com.open6.taleadventure.presentation.base.BaseViewBindingActivity

class TaleActivity : BaseViewBindingActivity<ActivityTaleBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setBinding(inflater: LayoutInflater): ActivityTaleBinding =
        ActivityTaleBinding.inflate(inflater)
}