package com.open6.taleadventure.presentation.onboard.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.data.local.TaleAdventureSharedPreferences
import com.open6.taleadventure.databinding.FragmentOnboardFourthBinding
import com.open6.taleadventure.presentation.base.fragment.BaseDataBindingFragment
import com.open6.taleadventure.presentation.main.view.MainActivity
import com.open6.taleadventure.presentation.onboard.viewmodel.OnboardFourthViewModel
import com.open6.taleadventure.util.PublicString

class OnboardFourthFragment :
    BaseDataBindingFragment<FragmentOnboardFourthBinding>(R.layout.fragment_onboard_fourth) {

    private val viewModel by viewModels<OnboardFourthViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickEvents()
    }

    private fun setClickEvents() {
        setCompleteTVClickEvent()
    }

    private fun setCompleteTVClickEvent() {
        binding.tvOnboardFourthComplete.setOnClickListener {
            val activity = requireActivity()
            startActivity(Intent(activity, MainActivity::class.java))
            TaleAdventureSharedPreferences.setBoolean(
                PublicString.DID_USER_WATCHED_ONBOARDING, true
            )
            if (!activity.isFinishing) activity.finish()
        }
    }
}