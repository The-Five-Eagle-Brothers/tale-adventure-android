package com.taleadventure.teamfiveeagles.presentation.category.genre

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.taleadventure.teamfiveeagles.R
import com.taleadventure.teamfiveeagles.data.local.TaleAdventureSharedPreferences
import com.taleadventure.teamfiveeagles.databinding.FragmentCategoryGenreBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseViewBindingFragment
import com.taleadventure.teamfiveeagles.presentation.main.MainActivity
import com.taleadventure.teamfiveeagles.util.extensions.addSourceList

class CategoryGenreFragment : BaseViewBindingFragment<FragmentCategoryGenreBinding>() {

    private val selectedGenreBtn: MutableLiveData<Button?> = MutableLiveData()
    private val selectedLanguageBtn: MutableLiveData<Button?> = MutableLiveData()
    private val isValidToComplete: MediatorLiveData<Boolean> = MediatorLiveData()

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentCategoryGenreBinding =
        FragmentCategoryGenreBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
        setClickEvents()
        setObservers()
    }

    private fun setObservers() {
        isValidToComplete.observe(viewLifecycleOwner) { isValidToComplete ->
            binding.btnCategoryGenreComplete.isEnabled = isValidToComplete
        }
    }

    private fun setData() {
        setIsValidToComplete()
    }

    private fun setIsValidToComplete() {
        isValidToComplete.addSourceList(selectedGenreBtn, selectedLanguageBtn) {
            selectedGenreBtn.value != null && selectedLanguageBtn.value != null
        }
    }

    private fun setClickEvents() {
        setGenreBtnClickEvents()
        setLanguageBtnClickEvents()
        setCompleteBtnClickEvent()
    }

    private fun setCompleteBtnClickEvent() {
        binding.btnCategoryGenreComplete.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }
        TaleAdventureSharedPreferences.setBoolean(getString(R.string.did_user_set_category), true)
    }

    private fun setGenreBtnClickEvents() {
        setDomesticBtnClickEvent()
        setWesternBtnClickEvent()
    }

    private fun setDomesticBtnClickEvent() {
        binding.btnCategoryGenreDomestic.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected
            if (selectedGenreBtn.value == btn) {
                selectedGenreBtn.value = null
                return@setOnClickListener
            }
            unselectPreviousGenreBtn()
            selectedGenreBtn.value = btn as? Button
        }
    }

    private fun setWesternBtnClickEvent() {
        binding.btnCategoryGenreWestern.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected
            if (selectedGenreBtn.value == btn) {
                selectedGenreBtn.value = null
                return@setOnClickListener
            }
            unselectPreviousGenreBtn()
            selectedGenreBtn.value = btn as? Button
        }
    }

    private fun unselectPreviousGenreBtn() {
        selectedGenreBtn.value?.isSelected = false
    }

    private fun setLanguageBtnClickEvents() {
        setKorBtnClickEvent()
        setEngBtnClickEvent()
        setJpnBtnClickEvent()
    }

    private fun setKorBtnClickEvent() {
        binding.btnCategoryGenreKor.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected
            if (selectedLanguageBtn.value == btn) {
                selectedLanguageBtn.value = null
                return@setOnClickListener
            }
            unselectPreviousLanguageBtn()
            selectedLanguageBtn.value = btn as? Button
        }
    }

    private fun setEngBtnClickEvent() {
        binding.btnCategoryGenreEng.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected
            if (selectedLanguageBtn.value == btn) {
                selectedLanguageBtn.value = null
                return@setOnClickListener
            }
            unselectPreviousLanguageBtn()
            selectedLanguageBtn.value = btn as? Button
        }
    }

    private fun setJpnBtnClickEvent() {
        binding.btnCategoryGenreJpn.setOnClickListener { btn ->
            btn.isSelected = !btn.isSelected
            if (selectedLanguageBtn.value == btn) {
                selectedLanguageBtn.value = null
                return@setOnClickListener
            }
            unselectPreviousLanguageBtn()
            selectedLanguageBtn.value = btn as? Button
        }
    }

    private fun unselectPreviousLanguageBtn() {
        selectedLanguageBtn.value?.isSelected = false
    }
}