package com.example.composeexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    val isDarkTheme = MutableLiveData(false)
}