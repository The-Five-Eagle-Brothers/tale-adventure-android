package com.android.ssutudy.util.publics

import android.util.Log
import com.android.ssutudy.data.remote.model.ErrorResponseDto
import com.android.ssutudy.util.publics.PublicString.TAG
import kotlinx.serialization.json.Json
import retrofit2.HttpException

object PublicFunction {
    fun makeLog(msg: String) {
        Log.d(TAG, msg)
    }

    fun getErrorMessage(result: Throwable): String {
        when (result) {
            is HttpException -> {
                val data =
                    Json.decodeFromString<ErrorResponseDto>(
                        result.response()?.errorBody()?.string() ?: return "예기치 못한 에러 발생2"
                    )
                return data.errorMessage
            }

            else -> {
                Log.e("okhttp", result.message.toString())
                return "예기치 못한 에러가 발생했습니다"
            }
        }
    }
}