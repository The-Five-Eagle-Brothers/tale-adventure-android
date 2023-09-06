package com.open6.taleadventure.presentation.end.view

import android.os.Bundle
import androidx.activity.viewModels
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.ActivityEndBinding
import com.open6.taleadventure.presentation.base.activity.BaseDataBindingActivity
import com.open6.taleadventure.presentation.end.adapter.WordsAdapter
import com.open6.taleadventure.presentation.end.viewmodel.EndViewModel
import com.open6.taleadventure.util.PublicString.CHAPTER_NAME
import com.open6.taleadventure.util.PublicString.TALE_NAME
import com.open6.taleadventure.util.extensions.makeToastMessage

class EndActivity : BaseDataBindingActivity<ActivityEndBinding>(R.layout.activity_end) {
    private val viewModel by viewModels<EndViewModel>()
    private val wordsAdapter by lazy { WordsAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getData()
        setViews()
        setClickEvents()
        setObservers()
    }

    private fun setObservers() {
        setGameWordObservers()
        setErrorObservers()
        setPatchBookmarkObservers()
    }

    private fun setPatchBookmarkObservers() {
        setPatchBookmarkSuccessObservers()
        setPatchBookmarkErrorObservers()
    }

    private fun setPatchBookmarkSuccessObservers() {
        viewModel.updateBookmarkSuccessResponse.observe(this) { successMessage ->
            if (!isFinishing) finish()
        }
    }

    private fun setPatchBookmarkErrorObservers() {
        viewModel.updateBookmarkErrorResponse.observe(this) { errorMessage ->
            if (!isFinishing) finish()
        }
    }

    private fun setErrorObservers() {
        viewModel.errorResponse.observe(this) { errorMessage ->
            makeToastMessage(errorMessage)
        }
    }

    private fun setGameWordObservers() {
        viewModel.gameWords.observe(this) { successData ->
            successData?.map {
                viewModel.isBookmarkedList.add(element = it.bookMark)
            }
            wordsAdapter.submitList(successData)
        }
    }

    private fun getData() {
        val chapterName = intent.getStringExtra(CHAPTER_NAME)
        if (!chapterName.isNullOrBlank()) {
            viewModel.getChapterWords(chapterName)
        } else {
            intent.getStringExtra(TALE_NAME)?.let { viewModel.getMyWords(it) }
        }
    }

    private fun setClickEvents() {
        setCompleteIVClickEvent()
    }

    private fun setCompleteIVClickEvent() {
        binding.btnEndComplete.setOnClickListener {
            viewModel.updateBookmark()
        }
    }

    private fun setViews() {
        setScoreAdapter()
    }

    private fun setScoreAdapter() {
        binding.rvEndWords.adapter = wordsAdapter
        wordsAdapter.setOnItemClick(changeIsBookmarked)
    }

    private val changeIsBookmarked: (position: Int, isBookmarked: Boolean) -> Unit =
        { position, isBookmarked ->
            viewModel.isBookmarkedList[position] = isBookmarked
        }

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}