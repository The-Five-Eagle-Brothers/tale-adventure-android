package com.open6.taleadventure.util

object PublicString {
    // Data
    const val AUTHORIZATION = "Authorization"
    const val LOGIN_PATH = "/auth/kakao"
    const val GET_HOME_DATA_PATH = "/home/me"
    const val GET_MY_WORD_DATA_PATH = "/talebook/retrieve"
    const val GET_CHAPTERS_PATH = "/chapter/retrieve"
    const val GET_CHAPTER_WORD_PATH = "/word/retrieve"
    const val GET_MY_WORD_PATH = "/word/retrieve/book-mark"
    const val PATCH_WORD_IS_BOOKMARKED_PATH = "/word/update/book-mark"
    const val CHECK_USER_INFO_VALID_PATH = "/member/valid"
    const val SET_AGE_PATH = "/member/set/age"

    // Error Messages
    const val SERVER_CONNECTION_ERROR_MESSAGE = "서버와 연결하는데 실패하였습니다"
    const val NETWORK_ERROR_MESSAGE = "네트워크에 연결하는데 실패하였습니다"
    const val UNEXPECTED_ERROR_MESSAGE = "예기치 못한 에러가 발생하였습니다"

    // SharedPreferences
    const val ACCESS_TOKEN = "access token"
    const val DID_USER_CHOOSE_TO_BE_NOTIFIED = "did user choose to be notified"
    const val DID_USER_WATCHED_ONBOARDING = "did user watched onboarding"

    // Intent Extra Key
    const val TALE_NAME = "tale name"
    const val CHAPTER_NAME = "chapter name"
    const val IS_FROM_CHAPTER = "is from chapter"

    // Notification
    const val NOTIFICATION_ID = 0
    const val NOTIFICATION_CONTENT_TITLE_KEY = "title"
    const val NOTIFICATION_CONTENT_TEXT_KEY = "body"
}