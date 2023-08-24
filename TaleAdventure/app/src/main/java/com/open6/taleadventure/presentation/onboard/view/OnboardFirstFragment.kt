package com.open6.taleadventure.presentation.onboard.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentOnboardFirstBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingFragment
import com.open6.taleadventure.presentation.onboard.viewmodel.OnboardFirstViewModel
import com.open6.taleadventure.util.builder.ViewIntMapBuilder

class OnboardFirstFragment :
    BaseDataBindingFragment<FragmentOnboardFirstBinding>(R.layout.fragment_onboard_first) {

    private val viewModel by viewModels<OnboardFirstViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        setClickEvents()
    }

    private fun setClickEvents() {
        setNextTVClickEvent()
    }

    private fun setNextTVClickEvent() {
        binding.tvOnboardFirstNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboardFirstFragment_to_onboardSecondFragment)
        }
    }

    private fun setData() {
        setAgeMap()
    }

    private fun setAgeMap() {
        with(binding) {
            val ageMap = ViewIntMapBuilder().addView(tvOnboardFirstAgeFirst, 2)
                .addView(tvOnboardFirstAgeSecond, 5).addView(tvOnboardFirstAgeThird, 8)
                .addView(tvOnboardFirstAgeFourth, 9).build()

            viewModel.setAgeMap(ageMap)
        }
    }

}