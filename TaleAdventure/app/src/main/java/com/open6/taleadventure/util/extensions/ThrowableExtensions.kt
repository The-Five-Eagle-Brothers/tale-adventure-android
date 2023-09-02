package com.open6.taleadventure.util.extensions

import com.open6.taleadventure.util.PublicString.NETWORK_ERROR_MESSAGE
import com.open6.taleadventure.util.PublicString.UNEXPECTED_ERROR_MESSAGE
import retrofit2.HttpException
import java.net.ConnectException

fun Throwable.getErrorMessage(): String {
    return when (this) {
        is HttpException -> this.response()?.errorBody()?.string() ?: UNEXPECTED_ERROR_MESSAGE
        is ConnectException -> NETWORK_ERROR_MESSAGE
        else -> {
            UNEXPECTED_ERROR_MESSAGE
        }
    }
}