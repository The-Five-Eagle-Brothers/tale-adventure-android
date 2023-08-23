package com.open6.taleadventure.presentation.onboard.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentOnboardFirstBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingFragment
import com.open6.taleadventure.presentation.onboard.viewmodel.OnboardFirstViewModel

class OnboardFirstFragment :
    BaseDataBindingFragment<FragmentOnboardFirstBinding>(R.layout.fragment_onboard_first) {

    private val viewModel by viewModels<OnboardFirstViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}