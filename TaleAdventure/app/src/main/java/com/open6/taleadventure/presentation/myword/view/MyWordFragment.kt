package com.open6.taleadventure.presentation.myword.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.data.remote.model.myword.ResponseMyWordDto
import com.open6.taleadventure.databinding.FragmentMyWordBinding
import com.open6.taleadventure.presentation.base.fragment.BaseDataBindingFragment
import com.open6.taleadventure.presentation.myword.adapter.StoryAdapter
import com.open6.taleadventure.presentation.myword.viewmodel.MyWordViewModel
import com.open6.taleadventure.presentation.wordgame.view.WordGameActivity
import com.open6.taleadventure.util.PublicString.IS_FROM_CHAPTER
import com.open6.taleadventure.util.PublicString.TALE_NAME
import com.open6.taleadventure.util.extensions.makeToastMessage

class MyWordFragment : BaseDataBindingFragment<FragmentMyWordBinding>(R.layout.fragment_my_word) {
    private val viewModel by viewModels<MyWordViewModel>()
    private var storyAdapter: StoryAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        setViews()
        setObservers()
    }

    private fun setObservers() {
        setGetMyWordDataObservers()
    }

    private fun setGetMyWordDataObservers() {
        setGetMyWordDataSuccessObservers()
        setGetMyWordDataErrorObservers()
    }

    private fun setGetMyWordDataSuccessObservers() {
        viewModel.getMyWordDataSuccessResponse.observe(viewLifecycleOwner) { successData ->
            successData.updateStoryAdapter()
        }
    }

    private fun List<ResponseMyWordDto>?.updateStoryAdapter() {
        storyAdapter?.run {
            submitList(this@updateStoryAdapter)
            setOnItemClick(navigateToWordGameActivity)
        }
    }

    private val navigateToWordGameActivity: (String) -> Unit = { taleName ->
        kotlin.run {
            Intent(activity, WordGameActivity::class.java).putExtra(TALE_NAME, taleName).putExtra(
                IS_FROM_CHAPTER, false
            ).also { intent ->
                startActivity(intent)
            }
        }
    }

    private fun setGetMyWordDataErrorObservers() {
        viewModel.getMyWordDataErrorResponse.observe(viewLifecycleOwner) { errorMessage ->
            makeToastMessage(errorMessage)
        }
    }

    private fun getData() {
        viewModel.getMyWordData()
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