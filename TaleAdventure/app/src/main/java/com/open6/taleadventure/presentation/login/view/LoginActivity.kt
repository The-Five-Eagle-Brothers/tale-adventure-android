package com.open6.taleadventure.presentation.login.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.open6.taleadventure.R
import com.open6.taleadventure.data.local.TaleAdventureSharedPreferences
import com.open6.taleadventure.databinding.ActivityLoginBinding
import com.open6.taleadventure.presentation.base.BaseViewBindingActivity
import com.open6.taleadventure.presentation.login.viewmodel.LoginViewModel
import com.open6.taleadventure.presentation.main.view.MainActivity
import com.open6.taleadventure.presentation.onboard.view.OnboardActivity
import com.open6.taleadventure.util.PublicString.ACCESS_TOKEN
import com.open6.taleadventure.util.PublicString.DID_USER_WATCHED_ONBOARD
import com.open6.taleadventure.util.extensions.makeToastMessage
import timber.log.Timber

class LoginActivity : BaseViewBindingActivity<ActivityLoginBinding>() {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAutoLogin()
        setClickEvents()
        setObservers()
    }

    private fun setAutoLogin() {
        val isUserLoggedIn = !TaleAdventureSharedPreferences.getString(ACCESS_TOKEN).isNullOrBlank()
        if (!isUserLoggedIn) return

        val didUserWatchedOnboard =
            TaleAdventureSharedPreferences.getBoolean(DID_USER_WATCHED_ONBOARD)
        if (didUserWatchedOnboard) {
            startActivity(Intent(this, MainActivity::class.java))
            if (!isFinishing) finish()
        } else {
            startActivity(Intent(this, OnboardActivity::class.java))
            if (!isFinishing) finish()
        }
    }

    private fun setObservers() {
        setLoginWithKakaoResponseObservers()
    }

    private fun setLoginWithKakaoResponseObservers() {
        setLoginWithKakaoSuccessResponseObservers()
        setLoginWithKakaoErrorResponseObservers()
    }

    private fun setLoginWithKakaoSuccessResponseObservers() {
        viewModel.loginWithKakaoSuccessResponse.observe(this) { successData ->
            TaleAdventureSharedPreferences.setString(ACCESS_TOKEN, successData?.appToken)
            val didUserWatchedOnboard =
                TaleAdventureSharedPreferences.getBoolean(DID_USER_WATCHED_ONBOARD)
            if (didUserWatchedOnboard) {
                startActivity(Intent(this, MainActivity::class.java))
                if (!isFinishing) finish()
            } else {
                startActivity(Intent(this, OnboardActivity::class.java))
                if (!isFinishing) finish()
            }
        }
    }

    private fun setLoginWithKakaoErrorResponseObservers() {
        viewModel.loginWithKakaoErrorResponse.observe(this) { errorMessage ->
            makeToastMessage(errorMessage)
        }
    }

    private fun setClickEvents() {
        setKakaoLoginIVClickEvent()
    }

    private fun setKakaoLoginIVClickEvent() {
        binding.ivLoginKakao.setOnClickListener {
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Timber.e("카카오계정으로 로그인 실패 : $error")
                } else if (token != null) {
                    Timber.e("카카오계정으로 로그인 성공 : ${token.accessToken}")
                    viewModel.loginWithKakao(
                        getString(
                            R.string.kakao_token_wrapper, token.accessToken
                        )
                    )
                }
            }

            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                    if (error != null) {
                        Timber.e("카카오톡으로 로그인 실패 : $error")

                        // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                        // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                        if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                            return@loginWithKakaoTalk
                        }

                        // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                    } else if (token != null) {
                        Timber.i("카카오톡으로 로그인 성공 ${token.accessToken}")
                        callback.invoke(token, null)
                    }
                }
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }
    }

    override fun setBinding(inflater: LayoutInflater): ActivityLoginBinding =
        ActivityLoginBinding.inflate(inflater)

}