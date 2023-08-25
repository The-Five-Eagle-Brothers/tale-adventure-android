package com.open6.taleadventure.presentation.word.view

import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentWordBinding
import com.open6.taleadventure.presentation.base.BaseDataBindingFragment
import com.open6.taleadventure.presentation.word.viewmodel.WordViewModel

class WordFragment : BaseDataBindingFragment<FragmentWordBinding>(R.layout.fragment_word) {
    private val viewModel by viewModels<WordViewModel>()

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}