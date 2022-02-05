package com.example.movieslist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Movies(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
    ) {
}