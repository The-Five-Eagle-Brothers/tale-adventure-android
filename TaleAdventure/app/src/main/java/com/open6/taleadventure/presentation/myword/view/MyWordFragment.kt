package com.open6.taleadventure.presentation.myword.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentMyWordBinding
import com.open6.taleadventure.presentation.base.fragment.BaseDataBindingFragment
import com.open6.taleadventure.presentation.myword.adapter.StoryAdapter
import com.open6.taleadventure.presentation.myword.viewmodel.MyWordViewModel

class MyWordFragment : BaseDataBindingFragment<FragmentMyWordBinding>(R.layout.fragment_my_word) {
    private val viewModel by viewModels<MyWordViewModel>()
    private var storyAdapter: StoryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
    }

    private fun setViews() {
        setStoryAdapter()
    }

    private fun setStoryAdapter() {
        storyAdapter = StoryAdapter()
        binding.rvMyWordStory.adapter = storyAdapter
    }

    override fun onDestroyView() {
        storyAdapter = null
        super.onDestroyView()
    }

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}