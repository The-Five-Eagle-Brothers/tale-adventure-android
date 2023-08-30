package com.open6.taleadventure.presentation.word.view

import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentMyWordBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingFragment
import com.open6.taleadventure.presentation.word.viewmodel.MyWordViewModel

class MyWordFragment : BaseDataBindingFragment<FragmentMyWordBinding>(R.layout.fragment_my_word) {
    private val viewModel by viewModels<MyWordViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}