package com.taleadventure.teamfiveeagles.presentation.login.view

import android.os.Bundle
import androidx.activity.viewModels
import com.taleadventure.teamfiveeagles.R
import com.taleadventure.teamfiveeagles.databinding.ActivityLoginBinding
import com.taleadventure.teamfiveeagles.presentation.base.BaseDataBindingActivity
import com.taleadventure.teamfiveeagles.presentation.login.viewmodel.LoginViewModel

class LoginActivity : BaseDataBindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun bindViewModelWithBinding() {
        binding.vm = viewModel
    }

//    private fun setKakaoLoginBtnClickEvent() {
//        val kakaoLoginCallback: (OAuthToken?, Throwable?) -> Unit = { socialToken, error ->
//            if (error != null) {
//                Timber.e(error)
//            } else if (socialToken != null) {
//                Timber.d(socialToken.accessToken)
//            }
//        }
//
//        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
//            // 카카오톡 로그인
//            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
//                // 로그인 실패 부분
//                if (error != null) {
//                    // 사용자 취소
//                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
//                        return@loginWithKakaoTalk
//                    }
//                    // 다른 오류 - 카톡으로 안 될 경우
//                    else {
//                        UserApiClient.instance.loginWithKakaoAccount(
//                            this, callback = kakaoLoginCallback
//                        ) // 카카오 이메일 로그인
//                    }
//                }
//                // 로그인 성공 부분
//                else if (token != null) {
//                    kakaoLoginCallback.invoke(token, error)
//                }
//            }
//        } else {
//            Timber.d("카카오톡이 설치되어있지 않습니다.")
//            // 카카오 이메일 로그인
//            UserApiClient.instance.loginWithKakaoAccount(
//                this, callback = kakaoLoginCallback
//            )
//        }
//    }
}