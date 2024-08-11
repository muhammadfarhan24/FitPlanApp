package com.msv.appfitplanmobile.screens.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import com.msv.appfitplanmobile.data.local.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    fun getLogin():Boolean = preferences.getLogin()

}