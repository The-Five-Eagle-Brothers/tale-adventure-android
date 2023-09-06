package com.open6.taleadventure.util

object PublicString {
    // Data
    const val AUTHORIZATION = "Authorization"
    const val LOGIN_PATH = "auth/kakao"
    const val GET_HOME_DATA_PATH = "home/me"
    const val GET_MY_WORD_DATA_PATH = "talebook/retrieve"
    const val GET_CHAPTERS_PATH = "chapter/retrieve"

    // Error Messages
    const val SERVER_CONNECTION_ERROR_MESSAGE = "서버와 연결하는데 실패하였습니다"
    const val NETWORK_ERROR_MESSAGE = "네트워크에 연결하는데 실패하였습니다"
    const val UNEXPECTED_ERROR_MESSAGE = "예기치 못한 에러가 발생하였습니다"

    // SharedPreferences
    const val ACCESS_TOKEN = "ACCESS_TOKEN"
    const val DID_USER_WATCHED_ONBOARD = "DID_USER_WATCHED_ONBOARD"

    // Intent Extra Key
    const val TALE_NAME = "TALE_NAME"
}