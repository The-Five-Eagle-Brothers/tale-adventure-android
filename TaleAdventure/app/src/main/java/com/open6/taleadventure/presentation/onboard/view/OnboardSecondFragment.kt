package com.open6.taleadventure.presentation.onboard.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentOnboardSecondBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingFragment
import com.open6.taleadventure.presentation.onboard.viewmodel.OnboardSecondViewModel

class OnboardSecondFragment :
    BaseDataBindingFragment<FragmentOnboardSecondBinding>(R.layout.fragment_onboard_second) {
    private val navController by lazy { findNavController() }
    private val viewModel by viewModels<OnboardSecondViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickEvents()
    }

    private fun setClickEvents() {
        setNextTVClickEvent()
        setBackIVClickEvent()
    }

    private fun setBackIVClickEvent() {
        binding.ivOnboardSecondBack.setOnClickListener {
            navController.navigateUp()
        }
    }

    private fun setNextTVClickEvent() {
        binding.tvOnboardSecondNext.setOnClickListener {
            navController.navigate(R.id.action_onboardSecondFragment_to_onboardThirdFragment)
            viewModel.resetSelectedViews()
        }
    }

}