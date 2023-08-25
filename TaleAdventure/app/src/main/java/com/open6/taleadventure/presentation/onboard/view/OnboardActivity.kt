package com.open6.taleadventure.presentation.onboard.view

import android.os.Bundle
import android.view.LayoutInflater
import com.open6.taleadventure.databinding.ActivityOnboardBinding
import com.open6.taleadventure.presentation.base.BaseViewBindingActivity

class OnboardActivity : BaseViewBindingActivity<ActivityOnboardBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setBinding(inflater: LayoutInflater): ActivityOnboardBinding =
        ActivityOnboardBinding.inflate(inflater)
}