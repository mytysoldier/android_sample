package com.example.hellocompose2.ui.entity

import androidx.annotation.DrawableRes

data class Animal(@DrawableRes val resourceId: Int, val text: String)