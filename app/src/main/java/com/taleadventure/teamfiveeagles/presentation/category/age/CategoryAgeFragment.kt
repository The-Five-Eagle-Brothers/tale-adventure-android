package com.taleadventure.teamfiveeagles.presentation.category.age

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.navigation.fragment.findNavController
import com.taleadventure.teamfiveeagles.databinding.FragmentCategoryAgeBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseViewBindingFragment

class CategoryAgeFragment : BaseViewBindingFragment<FragmentCategoryAgeBinding>() {

    private val selectedBtn: MutableLiveData<Button?> = MutableLiveData()
    private val isAnyBtnSelected: LiveData<Boolean> = selectedBtn.map { selectedBtn ->
        selectedBtn != null
    }

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentCategoryAgeBinding = FragmentCategoryAgeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickEvents()
        setObservers()
    }

    private fun setObservers() {
        setIsAnyBtnSelectedObserver()
    }

    private fun setIsAnyBtnSelectedObserver() {
        isAnyBtnSelected.observe(viewLifecycleOwner) { isAnyBtnSelected ->
            binding.btnCategoryAgeNext.isEnabled = isAnyBtnSelected
        }
    }

    private fun setClickEvents() {
        setNextBtnClickEvent()
        setAgeCategoryBtnClickEvents()

    }

    private fun setNextBtnClickEvent() {
        binding.btnCategoryAgeNext.setOnClickListener {
            navigateToCategoryGenre()
            selectedBtn.value = null
        }
    }

    private fun navigateToCategoryGenre() {
        findNavController().navigate(CategoryAgeFragmentDirections.actionCategoryAgeFragmentToCategoryGenreFragment())
    }

    private fun setAgeCategoryBtnClickEvents() {
        setAgeCategoryFirstBtnClickEvent()
        setAgeCategorySecondBtnClickEvent()
        setAgeCategoryThirdBtnClickEvent()
        setAgeCategoryFourthBtnClickEvent()
    }

    private fun setAgeCategoryFirstBtnClickEvent() {
        binding.btnCategoryAgeFirstCategory.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected

            if (selectedBtn.value == btn) {
                selectedBtn.value = null
                return@setOnClickListener
            }

            unselectPreviousBtn()
            selectedBtn.value = btn as? Button
        }
    }

    private fun setAgeCategorySecondBtnClickEvent() {
        binding.btnCategoryAgeSecondCategory.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected
            if (selectedBtn.value == btn) {
                selectedBtn.value = null
                return@setOnClickListener
            }
            unselectPreviousBtn()
            selectedBtn.value = btn as? Button
        }
    }

    private fun setAgeCategoryThirdBtnClickEvent() {
        binding.btnCategoryAgeThirdCategory.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected
            if (selectedBtn.value == btn) {
                selectedBtn.value = null
                return@setOnClickListener
            }
            unselectPreviousBtn()
            selectedBtn.value = btn as? Button
        }
    }

    private fun setAgeCategoryFourthBtnClickEvent() {
        binding.btnCategoryAgeFourthCategory.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected
            if (selectedBtn.value == btn) {
                selectedBtn.value = null
                return@setOnClickListener
            }
            unselectPreviousBtn()
            selectedBtn.value = btn as? Button
        }
    }

    private fun unselectPreviousBtn() {
        if (isAnyBtnSelected.value == true) {
            selectedBtn.value?.isSelected = false
        }
    }

}