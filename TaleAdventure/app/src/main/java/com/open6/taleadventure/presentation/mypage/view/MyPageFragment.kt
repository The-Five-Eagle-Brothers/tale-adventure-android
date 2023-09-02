package com.open6.taleadventure.presentation.mypage.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.kakao.sdk.user.UserApiClient
import com.open6.taleadventure.R
import com.open6.taleadventure.databinding.FragmentMyPageBinding
import com.open6.taleadventure.presentation.base.fragment.BaseDataBindingFragment
import com.open6.taleadventure.presentation.mypage.viewmodel.MyPageViewModel
import timber.log.Timber

class MyPageFragment : BaseDataBindingFragment<FragmentMyPageBinding>(R.layout.fragment_my_page) {
    private val viewModel by viewModels<MyPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        setClickEvents()
    }

    private fun setClickEvents() {
        setOssTVClickEvent()
    }

    private fun setOssTVClickEvent() {
        binding.tvMyPageOss.setOnClickListener {
            startActivity(Intent(requireContext(), OssLicensesMenuActivity::class.java))
        }
    }

    private fun setViews() {
        setEmailTV()
        setSocialTV()
        setNickNameTV()
    }

    private fun setNickNameTV() {
        binding.tvMyPageNickname.text = getString(R.string.my_page_nickname, "잰조")
    }

    private fun setSocialTV() {
        binding.tvMyPageSocial.text = getString(R.string.my_page_social_type_kakao)
    }

    private fun setEmailTV() {
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Timber.e(getString(R.string.my_page_user_info_error, error.toString()))
            } else if (user != null) {
                binding.tvMyPageEmail.text = user.kakaoAccount?.email
            }
        }
    }

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }
}