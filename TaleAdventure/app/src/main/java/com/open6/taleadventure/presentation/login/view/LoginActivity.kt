package com.open6.taleadventure.presentation.login.view

import android.os.Bundle
import android.view.LayoutInflater
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.open6.taleadventure.databinding.ActivityLoginBinding
import com.open6.taleadventure.presentation.base.BaseViewBindingActivity
import timber.log.Timber

class LoginActivity : BaseViewBindingActivity<ActivityLoginBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setClickEvents()
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