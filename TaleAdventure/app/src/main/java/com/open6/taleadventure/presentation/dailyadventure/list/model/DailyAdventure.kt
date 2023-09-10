package com.open6.taleadventure.presentation.dailyadventure.list.model

import androidx.annotation.DrawableRes

data class DailyAdventure(
    @DrawableRes val image: Int,
    val day: Int,
)